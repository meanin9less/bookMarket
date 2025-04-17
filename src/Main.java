import java.util.Scanner;

// 클래스만 존재해도 생성되는 함수 = 스태틱
// new로 실제 객체르,ㄹ 구워내야 생성되는 함수 = 인스턴스
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookMarketManager manager = new BookMarketManager();
        manager.run();
    }
}


//변수 : 데이터가 저장될 메모리에 붙여진 이름 : 참조값 물리적 메모리주소 0x62fe24 > abc로 저장
// javac.exe 가 class파일로 만듦 => java.exe가 기계어로된 class파일을 실행함   => ctrl f5 의 기능
// class 파일은 1차번역이 되어 바이트코드로 바뀐 파일임
// 0x : 16진수라는 표기