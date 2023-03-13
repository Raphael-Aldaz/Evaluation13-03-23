
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.Entities.Formation;
import frm.fms.Dao.DaoFormations;

public class App {
	static DaoFormations formationDao = new DaoFormations();
	public static void main(String[] args) {
		int userStatus = 0;
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Bienvenue dans notre école ! Voici les formations disponnible !");
			formationDao.readAll().forEach(System.out::println);
			 int choice =0;
			 
			 while(choice != 10) {
				 displayMainMenu();
				 while(!scan.hasNextInt()) scan.next();
				choice =  scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Quelle catégorie voulez vous voire ? \n"
							+"1- Developpement Web \n"
							+"2- Web Design \n" 
							+"3- Sys Admin \n"
							+"4- Bureautique \n"
							+"5- Ajouter une formation a mon panier"
							);
					int choiceCat = scan.nextInt();
						displayAllFormations(formationDao.readAllByCategory(choiceCat)); 
					break;
					
				case 2 :
					displayAllFormations(formationDao.readAllByStatus(2)); 
				break;
				case 3 :
					displayAllFormations( formationDao.readAllByStatus(3));
					break;
				case 4 :
					System.out.println("Choisissez le mot clé");
					String keyWord = scan.next();
					displayAllFormations(formationDao.readAllByKeyWord(keyWord)); 
					break;
				case 5:
					
				
					
				
				}
			 }
		}
		
		
	}
	
	public static void displayMainMenu() {
		System.out.println("Que voulez vous faire ? Entrez le numéro correspondant : \n"
				+"1- Trier par catégories \n"
				+"2- Afficher les formations a distance \n"
				+"3- Afficher les formation en présentiel \n"
				+"4- Chercher par mot clé"
				);
	}
	
	public static  void displayAllFormations(ArrayList<Formation> list) {
		list.forEach(x -> System.out.println( x.getIdFormation() 
				+ "----" + x.getNameFormation() 
				+ "----" +  x.getDescriptionFormation() 
				+ "---" + x.getDurationFormation()
				+ "----" + x.getStatusFormation() 
				+ "---" + x.getPriceFormation() +"€ \n"));
	}
	
//	private static void displayArticlesByCategoryId( int choiceCat) {
//		System.out.println("saisissez l'id de la catégorie concerné");
//		
//	
//		
//			System.out.printf("              AFFICHAGE PAR CATEGORIE    %n");
//			
//			System.out.printf("------------------------------------------------------------%n");
//			System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s %n");
//			System.out.printf("------------------------------------------------------------%n");
//			formationDao.readAllByCategory(choiceCat).forEach( a -> System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s%n",a.getIdFormation(),a.getNameFormation(),a.getDescriptionFormation(), a.getDurationFormation(),a.getStatusFormation(), a.getPriceFormation()));
//	
//	}


}
