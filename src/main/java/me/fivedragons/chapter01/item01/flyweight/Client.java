package me.fivedragons.chapter01.item01.flyweight;

/**
 * flyWeight pattern
 */
public class Client {
    public static void main(String[] args) {
        Fontfactory fontfactory = new Fontfactory();
        Character c1 = new Character('h', "white", fontfactory.getFont("nanum:12"));
        Character c2 = new Character('e', "white", fontfactory.getFont("nanum:12"));
        Character c3 = new Character('l', "white", fontfactory.getFont("nanum:12"));

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}
