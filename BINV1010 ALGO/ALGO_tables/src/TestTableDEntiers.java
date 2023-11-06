public class TestTableDEntiers {
    public static void main(String[] args) {
        int[] tableARecopier = {-1,-5,-3,8};
        TableEntiers tableTestee = new TableEntiers(tableARecopier);
        System.out.println(tableTestee.contient(2));
    }
}
