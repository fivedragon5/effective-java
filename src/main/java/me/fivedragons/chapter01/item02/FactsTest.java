package me.fivedragons.chapter01.item02;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
//외부에서는 @builder의 생성자를 사용하지 못함
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FactsTest {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static void main(String[] args) {
        
        FactsTest factsTest = new FactsTestBuilder()
                .servingSize(100)
                .servings(10)
                .build();
    }
}
