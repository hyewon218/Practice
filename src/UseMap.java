import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


 //Map : Key Value 로 되어있는 자료구조(키를 사용하여 값을 얻는 일)
public class UseMap {
    public UseMap() {
        // JDK1.5이하인 경우 Generic을 사용할 수 없고, 객체만 저장 가능하다.
        
        // 1. 생성
        Map<String, String> map = new HashMap<>();
        
        // 2. 값 할당 - 키는 유일 , 값은 중복 가능, 입력되는 순서대로 값이 추가되지 않는다.
        map.put("Oracle", "대용량 데이터베이스");
        map.put("Java", "프로그래밍 언어");
        map.put("Python", "프로그래밍 언어");// 값은 중복 가능
        map.put("Java", "완벽한 객체지향 언어");// 키가 존재한다면 해당 키에 덮어 쓴다.
        map.put("HTML", "Markup Language");// 키가 존재한다면 해당 키에 덮어 쓴다.
        System.out.println(map.size() + " " + map);
        
        // 3. 값 얻기) 키를 사용하여 값을 얻는다.
        // 키에 해당하는 값이 없다면 null을 반환
        String val = map.get("Java");// Java,HTML
        System.out.println(val);
        // 4. 키가 존재하는지?
        String key = "Java";
        boolean flag = map.containsKey("Java");
        System.out.println(key + "키가 존재 " + flag);

        // 5. 값 삭제
        map.remove("Java");
        System.out.println("삭제 후 : " + map);

        /// 6. 모든 키 얻기
        Set<String> allkeys = map.keySet();
        System.out.println("맵이 가진 모든 키 : " + allkeys);

        // 7. 모든 값 얻기
        Iterator<String> ita = allkeys.iterator();// 모든 키가 iterator에들어감
        String value = "";
        while (ita.hasNext()) {// 키가 존재한다면
            value = map.get(ita.next());// 얻어낸 키를 가지고 맵의 값을 얻는다.
            System.out.println(value);

        }
        // 8. 모두 삭제
        map.clear();
        System.out.println("모두 삭제 : " + map.size() + "/" + map);
    }

    /**
     * 기본생성자를 사용하면 11개의 행이 자동 생성
     * MultiThread에서 동시접근 가능.
     * 데이터가 전체 행 갯수의 약 75%채워있을 때 가장 빠른 검색을 한다.
     */
    public void useHashtable(String key) {
        //1. 생성
        Map<String, String> bloodmap = new HashMap<>(100);
        //2. 값 할당
        bloodmap.put("A","세심하다");
        bloodmap.put("B","성질드럽다");
        bloodmap.put("AB","싸이코");
        bloodmap.put("O","우유부단하다");
        bloodmap.put("A","소심하다");

        //값 얻기
        String value=bloodmap.get(key.toUpperCase());

        if(!bloodmap.containsKey(key.toUpperCase())) {//키가 존재하는지?
            System.out.println(key+"혈액형은 사람의 것이 아닙니다.");
        }else {
            System.out.println(key+"형 의 특징은 : "+ value);
        }
    }
    /**
     * 기본생성자를 사용하면 16개의 행이 자동 생성
     * MultiThread에서 동시접근 불가능.
     * 데이터가 전체 행 갯수의 약 75%채워있을 때 가장 빠른 검색을 한다.
     */
    public void useHashMap(String key) {
        //1. 생성
        Map<String,String> map = new HashMap<>();
        //2. 값 할당
        map.put("INFP", "항상 선을 행할 준비가 되어 있는 부드럽고 친절한 이타주의자입니다.");
        map.put("INFJ", "차분하고 신비한 분위기를 풍기는 성격으로, 다른 사람에게 의욕을 불어넣는 이상주의자입니다.");
        map.put("ISTJ", "사실을 중시하는 믿음직한 현실주의자입니다.");
        map.put("ISFJ", "주변 사람을 보호할 준비가 되어 있는 헌신적이고 따뜻한 수호자입니다.");
        map.put("ISTP", "대담하면서도 현실적인 성격으로, 모든 종류의 도구를 자유자재로 다루는 장인입니다.");
        map.put("ISFP", "항상 새로운 경험을 추구하는 유연하고 매력 넘치는 예술가입니다.");

        //3. 값 얻기
        if (map.containsKey(key)) {//맵에 키가 존재한다면
            String value=map.get(key);//값 얻기
            System.out.println(key+"의 뜻은 "+value);
        }else {
            System.out.println(key+"MBTI는 준비되지 않았습니다.");
        }
    }

    public static void main(String[] args) {
        UseMap um=new UseMap();
        System.out.println("------------------------Hashtable사용------------------------------------");
        um.useHashtable("a");
        System.out.println("------------------------HashMap사용------------------------------------");
        um.useHashMap("INFP");
    }// main

}// class