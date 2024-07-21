# 멋사 2주차 스터디 자료

## 라이브러리와 프레임워크

### 프레임워크

- **어떠한 목적을 쉽게 달성할 수 있도록 해당 목적과 관련된 코드의 뼈대를 미리 만들어둔 것**
- 짜여진 틀 위해서 사용자가 코드를 작성해 어플리케이션 개발
- 개발할 수 있는 범위가 정해져 있음
  (메모리 관리, 이벤트 루프 등 공통 부분은 프레임워크가 관리, 사용자는 클래스, 메소드만 구현)
- ex) Spring Framework, Django, Flask

### 라이브러리

- **단순 활용가능한 도구의 집합**
- 개발자가 만든 클래스의 나열
- ex) pip 모듈, JQuery

### 차이점

**누가 제어권(제어 흐름)을 갖고 있느냐.**

- **프레임워크는 자기가 갖고 있고, 라이브러리는 개발자가 가지고 있음
  (제어의 역전)**
- 프레임워크라는 틀에 맞춰서 코드 짜기 vs 내가 필요한 라이브러리 갖다 쓰기
- 프레임워크는 집이고, 라이브러리는 그 집 안에 있는 가구

## 스프링 프레임워크

### 스프링 프레임워크란

> **스프링 프레임워크의 정의**
>
> - 엔터프라이즈용 Java 애플리케이션 개발을 편하게 할 수 있게 해주는 오픈소스 경량급 애플리케이션 프레임워크

**“엔터프라이즈용 Java 애플리케이션 개발을 편하게 할 수 있게 해주는”**

- 비즈니스 로직 = 기업이 제공하는 서비스를 코드로 구현
- 스프링이 등장하기 전엔 비즈니스 로직을 짜려고 기술 자체를 따로 공부함
- 스프링은 기술보다 로직에 집중하여 비즈니스 로직을 구현할 수 있게 해줌
  == 일이 줄었다 (난 로직만 짜면 스프링이 알아서 해줌)

**“오픈 소스”**

- 스프링은 모두에게나 무료
- 필요하다면 스프링 코드도 수정해서 사용해도 됌

**“경량급”**

- 스프링 크기가 어마어마한데.. 이게 경량?
- 스프링이 나오기 전 기술과 비교하여 개발자가 작성할 코드가 상대적으로 단순함 == 경량
- 코드의 복잡성을 낮춰줌

**“애플리케이션 프레임워크”**

- 아까 프레임워크는 어떤 ‘목적’을 가지고 짠 틀이라고 했음
- 스프링은 애플리케이션을 쉽게 개발하는게 목적
- 특정 업무나 기술 X, 애플리케이션 개발에 필요한 모든 분야 및 기술 코드의 뼈대

### 스프링 프레임워크 특징

<aside>
💡 **스프링의 대전제: 스프링은 객체지향 원칙을 강제한다**

</aside>

> **POJO 프로그래밍을 지향**
>

**POJO(Plain Old Java Object): 순수 자바만을 통해서 생성한 객체**

- 외부 라이브러리, 모듈 X 순수 자바!!

왜 굳이 순수 자바?

if 외부 기술 허용:

- 외부 기술을 갖다 썼다가 외부 기술이 바뀌면 외부 기술을 쓰고 있던 모든 객체의 코드를 전부 바꿔줘야함

if POJO 사용:

- 특정 기술이나 환경 종속 X ⇒ 유연하게 변화와 확장 대처
- 객체지향 설계 제한 없이 적용
- 코드가 단순해지니 테스트&디버깅 쉬움

<aside>
💡 이런 POJO를 위해 스프링은  **IoC/DI**, **AOP**, **PSA**를 지원함

</aside>

> **IoC/DI (제어의 역전/의존성 주입)**
>
- 자바 애플리케이션의 꽃은? 객체지향 ⇒ 객체 간의 관계를 적절히 맺어줌
- 객체 관계를 적절히 맺어주려면 개발자가 생각할게 참 많다..
  이걸 알아서 해주는게 프레임워크. (프레임워크는 제어권이 자기한테 있음)
- 개발자가 직접 new 키워드로 인스턴스를 만들고 있었는데, A가 사용할 객체를 B에서 C로 바꾸고 싶음 ⇒ 수동으로 다 바꿔줘야함

- 스프링을 사용한다면? 주입 객체만 바꾸면 됌
  A는 자기가 사용할 객체를 자기가 생성하는게 아니라 외부에서 받아오고 있기 때문
  ⇒ 누군가가 외부에서 객체를 주입하는 과정을 스프링이 대신 해준다~

    <aside>
    💡 **이처럼** **개발자가 아닌 스프링이 A가 사용할 객체를 생성하여 의존 관계를 맺어주는 것을 IoC(Inversion of Control, 제어의 역전)라고 하며, 
    그 과정에서 C를 A의 생성자를 통해 주입해주는 것을 DI(Dependency Injection, 의존성 주입)라고 한다**

    </aside>


> **AOP(Aspect Oriented Programming, 관심 지향 프로그래밍)**
>
- 핵심 로직과 부가 로직을 나누어 각각 모듈화하여 관리
- 코드에서 반복적으로 사용되는 부가 로직을 분리,모듈화해서 재사용하는 것이 목적

> **PSA (Portable Service Abstraction, 일관된 서비스 추상화)**
>
- 특정 기술과 관련된 서비스를 추상화하여 일관된 방식으로 사용될 수 있도록 한 것
- PSA == Interface
- ex) 트랜잭션, 데이터 액세스(JDBC,ORM),로깅 등
- 어노테이션, xml, javaConfig 등으로 제공

### 스프링 프레임워크 vs 스프링부트

스프링은 초기 설정이 너무 많음

이를 간단하게 만들어주는 ‘도구’가 스프링부트. 별개로 사용하는게 아님

> **스프링 부트 제공 기능**
>
> 1. 의존성 관리
> 2. 자동 설정
> 3. 내장 was
> 4. 모니터링 기능

### 스프링을 배워야 하는 이유

- 프레임워크가 제공하는 강제성으로 초보자들도 쉽게 퀄리티 있는 코드 작성 유도
- 프레임워크를 사용하는 사람들이 많아 관련 리소스가 풍부
- 스프링부트의 등장으로 빠르게 프로젝트 개발 가능
- 한국에서 수요가 많다 (취업 유리^^)

<aside>
💡 참고) 궁금한 사람은 보기

[백엔드 프레임워크 비교 ](https://www.notion.so/07a21c0359584d2a987f643589e9acf1?pvs=21)

</aside>

## Java 객체 생성

### 클래스란 무엇인가

**클래스: 객체를 설계(모델링)하는 도구**

→ 자료형 측면: 새로운 자료형을 만드는 도구

→ 객체지향 측면: 객체의 상태정보(멤버변수)와 행위정보(멤버메서드)를 뽑아서 설계하는 도구

### 객체 생성 과정의 이해

모델링된 객체를 사용하기 위해서는 메모리에 객체를 생성해야함

1. `Person p;`  객체 변수 선언
2. `p = new Person();` new 연산자로 객체 생성 (인스턴스)

이렇게 정의된 클래스를 통해 동일한 객체(인스턴스)를 무한정 찍어낼 수 있음.

쉽게 생각해서 클래스는 붕어빵 틀, 인스턴스는 붕어빵

붕어빵 틀로 붕어빵을 만들어야
붕어빵의 실체(메모리 할당)가 생김

## 클래스 인스턴스 사용 방법

### `new` 키워드 사용

- 구상 클래스(Concrete class)에 사용
- 편하고 직관적
- 하지만 이렇게 객체를 생성하게 되면 의존 역전 원칙을 위반하게 되며, 결과적으로 확장 폐쇄 원칙을 위반하게 됌

```java
public Class LottoService{
	private final Lotto lotto = new Lotto();
}
```

### 싱글톤(Singleton) 패턴

- **객체의 인스턴스가 오직 1개만 생성**되는 패턴
- 어디서든지 같은 인스턴스에 접근 가능


> **사용 이유**
>
1. 메모리 낭비 방지
    - 처음에 한번 생성한 고정된 메모리 영역 사용
2. 데이터 공유가 쉬움 ( 하나의 인스턴스를 여러 곳에서 사용하기 때문에)

**⇒ 인스턴스가 단 하나만 필요하거나, 여러 객체에 걸쳐 상태를 공유해야 할 때 유용**

> **문제점**
>
1. 코드 자체가 많이 필요함
    - 정적 팩토리 메서드에 객체 생성을 확인하고 생성자를 호출하는 경우
      ⇒ 동시성 문제 해결 위해 `syncronized` 키워드를 사용
2. 테스트가 어려움
    - 싱글톤 인스턴스는 전역 상태, 즉 자원을 공유하고 있음
    - 독립적인 테스트를 수행하려면 매번 인스턴스 상태를 초기화 해줘야함
3. 의존성이 높아짐
    - new 클래스를 직접 사용하여 클래스 안에서 객체 생성 → 당연히 구체 클래스에 의존할 수 밖에 …
    - 다른 클래스로 바꾸고 싶으면? 직접 하나하나 찾아서 수정

```java
// LottoService Class
public Class LottoService{
	private final Lotto lotto;

	public LottoService(){
		this.lotto = Lotto.getInstance();
	}
}

// Lotto class
public Class Lotto{
	private static final Lotto INSTANCE= new Lotto();

	private Lotto(){};

	public static Lotto getInstance() {
        return INSTANCE;
    }
}

```

<aside>
💡 각각의 장단점이 있지만 이 친구들은 객체지향 원칙에 위배된다
객체지향 원칙을 따르려면 **의존성 주입**이 필요함

</aside>

## 스프링 빈과 스프링 컨테이너

### 스프링 컨테이너

- 스프링에서 자바 객체들을 관리하는 공간
- 자바 객체 == 빈(bean)
- 빈의 생성부터 소멸까지 개발자 대신 관리
- `BeanFactory` , `ApplicationContext` 로 나눌 수 있음

### 스프링 빈

- 스프링 컨테이너에 빈 인스턴스를 싱글톤 방식으로 생성
- 빈 이름은 항상 다르게 지어야함

<aside>
📌 **왜 스프링 빈을 싱글톤으로 생성할까?**

스프링이 주로 적용되는 대상이 **자바 엔터프라이즈 기술을 사용하는 서버환경**이기 때문!
클라이언트에서 요청이 올 때마다 각 로직을 담당하는 오브젝트를 새로 만들어서 사용한다면 **부하가 걸려 서버가 감당하기 힘들 것이다**

</aside>

### 스프링 컨테이너**(Spring Container)(Spring IOC Container)**

- **Bean들의 생명주기(Life Cycle)를 관리 → 생성, 관리, 제거 등**
- BeanFactory와 ApplicationContext라는 2개의 컨테이너로 제어하고 관리
  ( 보통 ApplicationContext를 컨테이너라고 한다 )
- 이 2개는 인터페이스로 각 구현체가 여러 개 있다
- 스프링컨테이너는 XML을 기반으로 만들 수 있고, 애노테이션 기반의 자바 설정 클래스로 만들 수 있다

<aside>
📌 **왜 스프링 컨테이너를 사용할까?**
객체를 생성하기 위해서는 new 생성자를 사용해야 한다. 그로 인해 애플리케이션에는 수많은 객체가 존재하고 서로를 참조하게 된다. 객체 간의 참조가 많아지면 의존성이 높아지는데, 이는 객체지향 프로그래밍의 핵심과는 먼 방식이다.
의존성 제어, 즉 객체 간의 의존성을 낮추기 위해 바로 Spring 컨테이너가 사용된다.

</aside>

### BeanFactory와 ApplicationContext

> **BeanFactory**
>
- 스프링 컨테이너의 최상위 인터페이스
- 스프링 빈을 관리하고 조회하는 역할을 담당
- `getBean()` 을 제공

> **ApplicationContext**
>
- Bean Factory를 포함한 여러 인터페이스들을 상속받은 인터페이스
- 빈 관리기능 + 편리한 부가기능을 제공
- ApplicatonContext가 제공하는 부가기능

    - **메시지소스를 활용한 국제화 기능**
      예를들어서 한국에서들어오면 한국어로, 영어권에서 들어오면영어로출력
    - **환경변수**
      로컬, 개발, 운영등을 구분해서처리
    - **편리한 리소스 조회**
      파일, 클래스패스, 외부 등에서리소스를 편리하게조회
    - **애플리케이션 이벤트**
      이벤트를발행하고구독하는 모델을 편리하게지원

### 스프링 컨테이너 생성 과정

1. **스프링 컨테이너 생성**

- `new AnnotationConfigApplicationContext(AppConfig.class)` → ApplicationContext의 구현체
- 스프링 컨테이너를 생성할 때는 구성정보(AppConfig.class)를 지정해주어야 한다
1. **스프링 빈 등록**

- 스프링 컨테이너는 파라미터로 넘어온 설정 클래스 정보를 사용해서 스프링 빈을 등록한다

<aside>
📌 **빈 이름**
- 기본값은 메서드 이름 사용
- 직접 부여할 수도 있음
!! 단 빈 이름은 항상 다른 이름을 부여해야함

</aside>

1. 스프링 빈 의존관계 설정 - 준비

1. 스프링 빈 의존관계 설정 - 완료

- 스프링 컨테이너는 설정 정보를 참고해서 의존관계를 주입(DI)한다
- 단순히 자바 코드를 호출하는 것 같지만, 차이가 있다. 이 차이는 뒤에 싱글톤 컨테이너에서~

### 다양한 설정 형식 - Java, XML

- 스프링 컨테이너는 다양한 형식의 설정정보를 받아드릴 수 있게 유연하게 설계되어 있다
    - 자바코드, XML, Groovy 등등

**애노테이션 기반 자바 코드 설정 사용**

- `AnnotationConfigApplicationContext` 클래스를 사용하면서 자바 코드로 된 설정정보를 넘기면 된다
- `AppConfig.class`

    ```java
    @Configuration     // 구성정보, 설정정보
    public class AppConfig {
        @Bean
        public MemberService memberService(){
            return new MemberSerivceImpl(memberRepository());
        }
    
        @Bean
        public OrderService orderService(){
            return new OrderSerivceImpl(memberRepository(), discountPolicy());
        }
    
        @Bean
        public static MemoryMemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }
    
        @Bean
        public DiscountPolicy discountPolicy(){
            return new RateDiscountPolicy();
        }
    }
    ```


**XML 설정 사용**

- 최근에는 스프링 부트를 많이 사용하면서 XML기반의 설정은 잘 사용하지 않음.
- XML을 사용하면 컴파일 없이 빈 설정 정보를 변경할 수 있다는 장점이 있음
- `appConfig.xml`

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
        <bean id="memberService" class="hello.core.member.MemberSerivceImpl" >
            <constructor-arg name="memberRepository" ref="memberRepository"/>
        </bean>
    
        <bean id="memberRepository" class="hello.core.member.MemoryMemberRepository"/>
    
        <bean id="orderService" class="hello.core.order.OrderSerivceImpl">
            <constructor-arg name="memberRepository" ref="memberRepository"/>
            <constructor-arg name="discountPolicy" ref="discountPolicy"/>
        </bean>
    
        <bean id="discountPolicy" class="hello.core.discount.RateDiscountPolicy"/>
    
    </beans>
    ```


## 스프링 빈 설정 메타 정보 - BeanDefinition

- 스프링이 이렇게 다양한 설정 형식을 지원하는 것은 **BeanDefinition 이라는 추상화 덕분**이다.
- 쉽게 말해 역할과 구현을 개념적으로 나눈 것
    - XML이나 자바 코드를 읽어서 BeanDefination을 만듬
    - 스프링 컨테이너는 BeanDefination만 알면 됌 ( XML인지 자바인지 상관 no )
- BeanDefinition 을 빈 설정 메타 정보라 한다
    - `@Bean` ,`<bean>` 당 각각 하나씩 메타 정보가 생성된다
- 빈 등록 방법

    1. 직접 등록 (xml)
    2. factory 메소드 (java - AppConfig) -> factory Bean을 통해 등록

- BeanDefinition 정보
    - BeanClassName: 생성할 빈의 클래스명(자바 설정처럼 팩토리 역할의 빈을 사용하면 없음)
    - factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름, 예) appConfig
    - factoryMethodName: 빈을 생성할 팩토리 메서드 지정, 예) memberService
    - Scope: 싱글톤(기본값)
    - lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때까지  최대한 생성을 지연처리 하는지 여부
    - InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드명
    - DestroyMethodName: 빈의 생명주기가 끝나서 제거하기 직전에 호출되는메서드 명
    - Constructor arguments, Properties: 의존관계 주입에서 사용한다. (자바설정 처럼 팩토리 역할의 빈을 사용하면 없음)

- 사실 실무에서 BeanDefinition을 직접 정의하거나 사용할 일은 거의 없다 ㅎㅎ

## 다시 보는 DI/IoC

**스프링 ⇒ 객체지향 원칙 강제 → 구현체가 아닌 역할을 중심으로 설계!**

역할과 구현을 분리

### 스프링 컨테이너

- 스프링 컨테이너는 빈(Bean)이라는 단위로 역할을 구성, 관리해준다
- 스프링 컨테이너는 구현 객체를 생성하고 연결하는 책임을 갖는다

### 제어의 역전(IoC)

- 객체에 대한 제어권이 바뀐 것을 의미
- 컨트롤의 제어권이 사용자가 아니라 프레임워크에 있어 필요에 따라 스프링에서 사용자의 코드를 호출한다
- 개발자는 필요한 부분만 개발하고 호출은 프레임워크 내부에서 결정

### 의존성 주입(DI)

- 각각의 계층이나 서비스들 간에 의존성이 존재할 경우 프레임워크가 서로 연결시켜준다
- 제어의 역전(IoC)의 한 종류로 볼 수 있다.
- 예시

  **의존성 주입x**

  새로운 구현체가 생겨날 때마다 지속적으로 바꿔줘야함

  **의존성 주입o**

  빈 설정 정보에 맞게 필요한 구현체를 외부에서 주입

  어노테이션을 통해 구현


## 좋은 객체 지향 설계

### 좋은 객체 지향 설계의 5가지 원칙 (SOLID)

클린코드로 유명한 로버트 마틴이 좋은 객체 지향 설계의 5가지 원칙을 정리

- **SRP: 단일 책임 원칙(single responsibility principle)**
    - 한 클래스는 하나의 책임만 가져야 한다.
    - 하나의 책임이라는 것은 모호
    - 중요한 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것
    - 예) UI 변경, 객체의 생성과 사용을 분리
- **OCP: 개방-폐쇄 원칙 (Open/closed principle)**
    - 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다
    - 다형성을 활용
    - 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현
    - 역할과 구현의 분리

  BUT!!

    - 구현 객체를 변경하려면 클라이언트 코드를 변경해야 한다.
    - 객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요하다.
- **LSP: 리스코프 치환 원칙 (Liskov substitution principle)**
    - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀
      수 있어야 한다
    - 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것, 다형성을 지원하기 위
      한 원칙, 인터페이스를 구현한 구현체는 믿고 사용하려면, 이 원칙이 필요하다.
    - 단순히 컴파일에 성공하는 것을 넘어서는 이야기
    - 예) 자동차 인터페이스의 엑셀은 앞으로 가라는 기능, 뒤로 가게 구현하면 LSP 위반, 느리더라도 앞으로 가야함
- **ISP: 인터페이스 분리 원칙 (Interface segregation principle)**
    - 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다
    - 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스로 분리
    - 사용자 클라이언트 -> 운전자 클라이언트, 정비사 클라이언트로 분리
    - 분리하면 정비 인터페이스 자체가 변해도 운전자 클라이언트에 영향을 주지 않음
    - 인터페이스가 명확해지고, 대체 가능성이 높아진다.
- **DIP: 의존관계 역전 원칙 (Dependency inversion principle)**
    - 프로그래머는 “추상화에 의존해야지, 구체화에 의존하면 안된다.” 의존성 주입은 이 원칙
      을 따르는 방법 중 하나다.
    - 쉽게 이야기해서 구현 클래스에 의존하지 말고, 인터페이스에 의존하라는 뜻
    - 앞에서 이야기한 역할(Role)에 의존하게 해야 한다는 것과 같다. 객체 세상도 클라이언트
      가 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다! 구현체에 의존하게 되면 변
      경이 아주 어려워진다.

---

- 객체 지향의 핵심은 다형성
- 하지만 다형성 만으로는 OCP, DIP를 지킬 수 없다

### 객체 지향 설계와 스프링

- 스프링은 다음 기술로 다형성 + OCP, DIP를 가능하게 지원
    - DI(Dependency Injection): 의존관계, 의존성 주입
    - DI 컨테이너 제공
- 클라이언트 코드의 변경 없이 기능 확장

### 정리

- 모든 설계에 **역할**과 **구현**을 분리
- 애플리케이션 설계도 공연을 설계 하듯이 배역만 만들어두고, 배우는 언제든지 유연하게
  변경할 수 있도록 만드는 것이 좋은 객체 지향 설계다.
- 이상적으로는 모든 설계에 인터페이스를 부여하자
- 기능을 확장할 가능성이 없다면, 구체 클래스를 직접 사용하고, 향후 꼭 필요할 때 리팩터링해서 인터페이스를 도입하는 것도 방법이다.