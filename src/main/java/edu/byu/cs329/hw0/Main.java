package edu.byu.cs329.hw0;

public class Main {

    public static void main(String[] args) {
        CharacterNode n7 = new CharacterNode('!');
        BooleanNode n6 = new BooleanNode(false, n7);
        NumberNode n5 = new NumberNode(316, n6);
        CharacterNode n4 = new CharacterNode('s', n5);
        NumberNode n3 = new NumberNode(13, n4);
        CharacterNode n2 = new CharacterNode('c', n3);
        BooleanNode n1 = new BooleanNode(true, n2);

        BuildStringVisitor bsv = new BuildStringVisitor();
        n1.accept(bsv);
        MultipleVisitor mv = new MultipleVisitor();
        n1.accept(mv);

        System.out.println("Compare the results of the two visitors:");
        System.out.println("BuildStringVisitor: " + bsv.getResult());
        System.out.println("MultipleVisitor: " + mv.getResult());
    }
}
