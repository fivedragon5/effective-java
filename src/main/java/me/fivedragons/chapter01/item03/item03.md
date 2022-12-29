# ITEM03 : 생성자나 열거 타입으로 싱글턴임을 보증하라.

## private 생성자 + public static final 필드
### 장점
 1. 간결하고 싱글턴임을 API에 들어낼 수 있다.
### 단점
 1. 싱글톤을 사용하는 클라이언트 테스트하기 어려워진다.
    - 테스트할때 대체를 사용하기 아렵다. (인터페이스를 사용하자.)
 2. 리플렉션으로 private 생성자를 호출할 수 있다.
    - Elvis.class.getConstructor();
      - public한 생성자에만 접근 가능
    - Elvis.class.getDeclaredConstructor();
      - 접근 지시자 상관 없이 접근 가능
      - defaultConstructor.setAccessible(true); 호출하려면 setAccessible값을 true로 바꿔야함
      - ex)
          ``` java
           /**
           * 싱글톤 오브젝트
           */
           public static final Elvis INSTANCE = new Elvis();
           private static boolean created;

           private Elvis() {
             // 최초 생성 후 이후에 오브젝트가 새로 만들어 지는것을 방지
             if (created) {
               throw new UnsupportedOperationException("can't be created by constructor.");
             }
             created = true;
           }
         ```
 3. 역직렬화 할 때 새로운 인스턴스가 생길 수 있다.
   -readResolve() 역직렬화시 새로운 인스턴스가 생기는것을 방지
     ``` java
         private Object readResolve() {
           return INSTANCE;
         }
     ```
## private 생성자 + 정적 팩터리 메서드
### 장점
 1. API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
 2. 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다.
    - 같은 인스터스지만 다른 제네릭 타입으로 사용할 수 있다.
 3. 정적 팩터리에 메서드 참조를 공급자(Supplier)로 사용할 수 있다.
### 단점
 
## 열거 타입
 1. 가장 간결한 방법이며 직렬화와 리플렉션에도 안전하다.
 2. 대부분의 상황에서는 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다.
 3. 테스트시에는 인터페이스를 사용한다 
   ``` java
     //implements 인터페이스 구현해서 사용 할것
     public enum Elvis {
   ```

## 공략
1. 리플렉션 API로 private 생성자 호출하기
2. 메서드 참조를 공급자로 사용할 수 있다.
    1. 스태틱 메소드 레퍼런스
    2. 인스턴스 메소드 레퍼런스
    3. 임의 객체의 인스턴스 메소드 레퍼런스
    4. 생성자 레퍼런스
3. Supplier<T>, 함수형 인터페이스
    1. 함수형 인터페이스는 람다 표현식과 메소드 참조에 대한 "타겟 타입"을 제공한다.
    2. 타겟 타입은 변수 할당, 메소드 호출, 타입 변환에 활용할 수 있다.
    3. 자바에서 제공하는 기본 함수형 인터페이스 익혀 둘 것. (java.util.function 패키지) 
    4. 함수형 인터페이스를 만드는 방법
4. 직렬화, 역직렬화, Serializable, transient
   1. 바이트스트림으로 변환한 객체를 파일로 저장하거나 네트워크를 통해 다른 시스템으로 전송할 수 있다.
   2. Serializable 인터페이스 구현
   3. transient를 사용해서 직렬화 하지 않을 필드 선언하기
   4. serialVersionUID는 언제 왜 사용하는가?
        - 역직렬화 시 직렬화 했던 파일의 serialVersionUID를 확인하는데 값이 다를경우 error