public class CoteCommentee {
   
   public static java.util.Scanner scanner = new java.util.Scanner(System.in);
   
   public static void main (String[] args) {
   
      System.out.print("Veuillez entrer la cote : ");
      double cote = scanner.nextDouble();
      
      if (cote < 10) {
         System.out.println("L'etudiant n'a pas valide l'UE.");
      } else if (cote < 14) {
         System.out.println("L'etudiant a valide l'UE.");
      } else if (cote < 16) {
         System.out.println("L'etudiant a valide l'UE avec une belle cote.");
      } else {  // cote >= 16
         System.out.println("L'etudiant a valide l'UE avec une tres belle cote.");
      }
      
   }

}