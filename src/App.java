
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.Entities.Formation;
import fr.fms.Job.Job;
import fr.fms.Job.Joblmpl;
import fr.fms.authentification.Authentification;
import frm.fms.Dao.DaoFormations;

public class App {
	private static DaoFormations formationDao = new DaoFormations();
	private static Joblmpl job = new Joblmpl(); 
	private static Authentification auth = new Authentification();
	public static void main(String[] args) {
	int userStatus = 0;
	Scanner scan = new Scanner(System.in);
		try {
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
							+"4- Bureautique"
							
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
					System.out.println("Selectionner l'id de la formation a ajouter");
					int formationToAdd = scan.nextInt();
					Formation formation = formationDao.read(formationToAdd);
					if(formation != null) {
						job.addFormation(formation);
					} else {
						System.out.println("The formation doesn't exist !");
					}
					
				case 6: 
					System.out.println("Vous voulez valider votre parnier ? o/n ");
					String validate = scan.next();
					if(userStatus != 0) {
						System.out.println("Souhaitez vous vous déconnecter ? Oui/Non");
						String response = scan.next();
						if(response.equalsIgnoreCase("Oui")) {
							System.out.println("A bientôt ");
							userStatus = 0;
						}				
					}
					else {
						System.out.println("Pour valider votre panier vous de vez vous connecter"
								+"1- Connectez vous :"
								+"2- Creation d'un compte");
						int connexion = scan.nextInt();
						if(connexion == 1) {
							System.out.println("saisissez votre login : ");
							String log = scan.next();
							System.out.println("saisissez votre password : ");
							String pwd = scan.next();
							
							int id = auth.existUser(log,pwd);
							if(id > 0)	{
								userStatus = id;
							}
							else {
								System.out.println("login ou password incorrect");
							}
						} else {
							System.out.println("Nouvel utilisateur, pour créer un compte, tapez ok");
							String ok = scan.next();
							if(ok.equalsIgnoreCase("ok")) {
								newUser();
							}
						}
					}
				case 7 :
					
					
					
				
				}
			 }
		}
	}
	
	public static void displayMainMenu() {
		System.out.println("Que voulez vous faire ? Entrez le numéro correspondant : \n"
				+"1- Trier par catégories \n"
				+"2- Afficher les formations a distance \n"
				+"3- Afficher les formation en présentiel \n"
				+"4- Chercher par mot clé \n"
				+"5- Ajouter une formation a mon panier \r"
				+"6- Valider mon panier \n"
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
	public static void newUser() {
		System.out.println("saisissez un login :");
		String login = scan.next();			
		int id = authenticate.existUser(login);	
		if(id == 0) { 
			System.out.println("saisissez votre password :");
			String password = scan.next();
			authenticate.addUser(login,password);		
			System.out.println("Ne perdez pas ces infos de connexion...");
			stop(2);
			System.out.println("création de l'utilisateur terminé, merci de vous connecter");
		}
		else	System.out.println("Login déjà existant en base, veuillez vous connecter");
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
