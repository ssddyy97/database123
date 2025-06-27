package chap6;
public class test11 {
    public static void main(String[] args) {
        tvremocon remote = new tvremocon();

        // 채널 10번 올리기
        for (int i = 0; i < 10; i++) {
            remote.ko28_ChannelUp();
        }

        // 채널 10번 내리기
        for (int i = 0; i < 10; i++) {
            remote.ko28_ChannelDn();
        }

        // 볼륨 5번 올리기
        for (int i = 0; i < 5; i++) {
            remote.ko28_VolUp();
        }

        // 볼륨 5번 내리기
        for (int i = 0; i < 5; i++) {
            remote.ko28_VolDn();
        }
    }
}
