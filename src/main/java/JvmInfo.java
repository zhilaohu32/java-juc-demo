import org.openjdk.jol.vm.VM;

import java.nio.ByteOrder;

/**
 * 输出JVM信息
 * @author FENGBIAO
 * @create 2023-03-28 11:15:24
 */
public class JvmInfo {
    public static void main(String[] args) {
        //查看字节序
        System.out.println(ByteOrder.nativeOrder());
        //打印当前jvm信息
        System.out.println("======================================");
        System.out.println(VM.current().details());
    }

}
