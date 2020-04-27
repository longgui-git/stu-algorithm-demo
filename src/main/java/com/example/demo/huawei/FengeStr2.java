package com.example.demo.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 题目描述
 * 在命令行输入如下命令：
 *
 * xcopy /s c:\ d:\，
 *
 * 各个参数如下：
 *
 * 参数1：命令字xcopy
 *
 * 参数2：字符串/s
 *
 * 参数3：字符串c:\
 *
 * 参数4: 字符串d:\
 *
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 *
 *
 *
 * 解析规则：
 *
 * 1.参数分隔符为空格
 * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s “C:\program files” “d:\”时，参数仍然是4个，第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 *
 *
 *
 *
 * 输入描述:
 * 输入一行字符串，可以有空格
 *
 * 输出描述:
 * 输出参数个数，分解后的参数，每个参数都独占一行
 *
 * 示例1
 * 输入
 * 复制
 * xcopy /s c:\\ d:\\
 * 输出
 * 复制
 * 4
 * xcopy
 * /s
 * c:\\
 * d:\\
 */
public class FengeStr2 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        List<String> fenge = fenge(s);
        System.out.println(fenge.size());
        fenge.forEach(v -> System.out.println(v));


    }


    public static List<String> fenge(String input) {

        ArrayList<String> list = new ArrayList<>();

        while (input.length() > 0) {
            input = input.trim();

            if (input.charAt(0) == '\"') {


                input = input.substring(1);

                int index = input.indexOf('\"');

                String v = input.substring(0, index);
                list.add(v);

                input = input.substring(index+1);

            } else {
                int index = input.indexOf('\"');
                if (index == -1) {
                    index = input.length();
                }
                String v = input.substring(0, index);
                String[] split = v.split("\\s+");
                for (String s : split) {
                    list.add(s);
                }
                input = input.substring(index);
            }
        }

        return list;
    }



}
