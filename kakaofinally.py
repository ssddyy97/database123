import urllib.request
from datetime import datetime
import pymysql
import json
import requests

# 토큰 경로
path = "C:\\Users\\USER\\Desktop\\python\\"

class Kakao:
    def __init__(self):
        self.app_key = "f10bec17f4453e47af01ab6dde3d3e8c"
        with open(path + "kakao_token.json", "r") as fp:
            self.tokens = json.load(fp)
        self.refresh_token()

    def refresh_token(self):
        url = "https://kauth.kakao.com/oauth/token"
        data = {
            "grant_type": "refresh_token",
            "client_id": self.app_key,
            "refresh_token": self.tokens['refresh_token']
        }
        res = requests.post(url, data=data).json()
        if 'access_token' in res:
            self.tokens['access_token'] = res['access_token']
        if 'refresh_token' in res:
            self.tokens['refresh_token'] = res['refresh_token']
        with open(path + "kakao_token.json", "w") as fp:
            json.dump(self.tokens, fp)

    def send_to_kakao(self, text):
        url = "https://kapi.kakao.com/v2/api/talk/memo/default/send"
        headers = {"Authorization": "Bearer " + self.tokens['access_token']}
        content = {
            "object_type": "text",
            "text": text,
            "link": {"mobile_web_url": "http://kakao.com"}
        }
        res = requests.post(url, headers=headers, data={"template_object": json.dumps(content)})
        print(res.json())


node_info = [
    ["Kopo21", "192.168.23.252:8855"],
    ["kopo23", "192.168.23.239:8855"],
    ["kopo24", "192.168.23.236:8855"],
    ["kopo25", "192.168.23.228:8855"],
    ["kopo28", "192.168.23.235:8855"],
    ["kopo29", "192.168.23.231:8855"],
    ["kopo30", "192.168.23.226:8855"],
    ["kopo33", "192.168.23.227:8855"],
    ["kopo34", "192.168.23.238:8855"],
    ["kopo35", "192.168.23.230:8855"],
    ["kopo36", "192.168.23.241:8855"],
    ["kopo37", "192.168.23.237:8855"],
    ["kopo38", "192.168.23.229:8855"],
    ["kopo39", "192.168.23.240:8855"],
    ["kopo40", "192.168.23.246:8855"]
]


def get_node_stat(nodename_, ip_):
    try:
        url = f"http://{ip_}/serverstat.txt"
        response = urllib.request.urlopen(url)
        r = response.read().decode().strip()
        line = r.split(',')

        if len(line) < 8:
            raise ValueError("서버에서 반환한 데이터 필드가 부족합니다.")

        _date_time = line[0]
        _hostname = line[1]
        _cpu = float(line[2])
        _mem = float(line[3])
        _dsk = float(line[4])
        _cpu_model = line[5]
        _mem_size = line[6]
        _dsk_size = line[7]

        now_time = datetime.now()
        try:
            node_time = datetime.strptime(_date_time, "%Y.%m.%d %H:%M:%S")
        except ValueError:
            node_time = datetime.strptime(_date_time, "%Y-%m-%d %H:%M:%S")
        time_diff = (now_time - node_time).total_seconds() / 60
        _stat = "2" if time_diff > 3 else "0"

    except urllib.error.URLError as e:
        print(f"[네트워크 오류] {e}")
        return {
            "nodename": nodename_,
            "date_time": datetime.now().strftime("%Y.%m.%d %H:%M:%S"),
            "hostname": "-",
            "cpu": "-",
            "mem": "-",
            "dsk": "-",
            "cpu_model": "-",
            "mem_size": "-",
            "dsk_size": "-",
            "stat": "1"
        }

    return {
        "nodename": nodename_,
        "date_time": _date_time,
        "hostname": _hostname,
        "cpu": _cpu,
        "mem": _mem,
        "dsk": _dsk,
        "cpu_model": _cpu_model,
        "mem_size": _mem_size,
        "dsk_size": _dsk_size,
        "stat": _stat
    }


def server_status_now_and_hist(conn, cur, node_data):
    queries = {
        "server_status_now": """
            REPLACE INTO server_status_now (
                date_time, nodename, hostname, cpu,
                mem, dsk, cpu_model, mem_size, dsk_size, stat
            ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        """,
        "server_status_hist": """
            INSERT INTO server_status_hist (
                date_time, nodename, hostname, cpu,
                mem, dsk, cpu_model, mem_size, dsk_size, stat
            ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        """
    }

    values = (
        node_data["date_time"],
        node_data["nodename"],
        node_data["hostname"],
        node_data["cpu"],
        node_data["mem"],
        node_data["dsk"],
        node_data["cpu_model"],
        node_data["mem_size"],
        node_data["dsk_size"],
        node_data["stat"]
    )

    try:
        cur.execute(queries["server_status_now"], values)
        cur.execute(queries["server_status_hist"], values)
        conn.commit()
        print(" now + hist 테이블에 저장 완료")

    except pymysql.MySQLError as e:
        print(f" MySQL INSERT 실패: {e}")
        conn.rollback()


def check_abnormal(node_data):
    issues = []
    if node_data["stat"] == "1":
        issues.append("네트워크 오류")
    elif node_data["stat"] == "2":
        issues.append("node agent 지연")

    if isinstance(node_data["cpu"], float) and node_data["cpu"] <= 10:
        issues.append("CPU 여유 10% 이하")
    if isinstance(node_data["mem"], float) and node_data["mem"] <= 30:
        issues.append("Memory 여유 30% 이하")
    if isinstance(node_data["dsk"], float) and node_data["dsk"] <= 30:
        issues.append("Disk 여유 30% 이하")

    return issues


if __name__ == "__main__":
    kakao = Kakao()

    try:
        conn = pymysql.connect(
            host='127.0.0.1',
            port=33067,
            user='root',
            password='lleejin71',
            db='kopoctc',
            charset='utf8'
        )
        cur = conn.cursor()

        for nodename, ip in node_info:
            node_data = get_node_stat(nodename, ip)
            print(f"\n노드: {nodename}, 수집 결과: {node_data}")

            # 네트워크 오류인 경우
            if node_data["stat"] == "1":
                msg = (
                    f"[네트워크 오류 감지]\n"
                    f"노드명: {nodename}\n"
                    f"시각: {node_data['date_time']}\n"
                    f"사유: 연결된 구성원으로부터 응답이 없거나, 호스트로부터 응답이 끊어짐"
                )
                kakao.send_to_kakao(msg)
                print(f"{nodename} 네트워크 오류 → DB 저장 생략\n")
                continue

            # DB 저장
            server_status_now_and_hist(conn, cur, node_data)

            # 이상 조건 감지
            issues = check_abnormal(node_data)
            if issues:
                msg = (
                    f"[이상 감지]\n"
                    f"노드명: {nodename}\n"
                    f"시각: {node_data['date_time']}\n"
                    f"문제 항목: {', '.join(issues)}"
                )
                kakao.send_to_kakao(msg)

    except pymysql.MySQLError as db_err:
        print(f"DB 연결 오류: {db_err}")

    finally:
        if 'cur' in locals():
            cur.close()
        if 'conn' in locals():
            conn.close()
        print("DB 연결 종료")