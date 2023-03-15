
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.Entities.Customer;
import fr.fms.Entities.Formation;
import fr.fms.Entities.User;
import fr.fms.Job.Joblmpl;
import fr.fms.authentification.Authentification;

import frm.fms.Dao.DaoFormations;
import frm.fms.Dao.DaoUser;

public class App {
	private static DaoFormations formationDao = new DaoFormations();
	private static Joblmpl job = new Joblmpl(); 
	private static DaoUser userDao = new DaoUser();
	private static Authentification auth = new Authentification();
	private static int userStatus = 0;
	private static Scanner scan = new Scanner(System.in);
	
	public static final int MAX_STRING_LENGTH = 50;
	public static final String COLOR_GREEN_BG = "\u001B[42m";
	public static final String COLOR_RESET_BG ="\u001B[0m";
	public static final String COLOR_WHITE_BG = "\u001B[47m";
	public static final String COLOR_BLACK = "\u001B[30m";
	public static final String COLOR_RED = "\u001B[31m";
	
	
	public static void main(String[] args) {
	
	try  {
		ArrayList<Formation> listFormation = formationDao.readAll();
		System.out.printf("----------------------------------------------------------------------------------------------------------%n");
		System.out.printf(COLOR_GREEN_BG +"   		 Bienvenue dans notre école ! Voici les formations disponnible !			 |%n"+ COLOR_RESET_BG);
		System.out.printf("----------------------------------------------------------------------------------------------------------%n");
		displayFormation(listFormation);
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
					displayFormation(formationDao.readAllByCategory(choiceCat)); 
				break;
				
			case 2 :
				displayFormation(formationDao.readAllByStatus(2)); 
			break;
			case 3 :
				displayFormation( formationDao.readAllByStatus(3));
				break;
			case 4 :
				System.out.println("Choisissez le mot clé");
				String keyWord = scan.next();
				displayFormation(formationDao.readAllByKeyWord(keyWord)); 
				break;
			case 5:
				displayFormation(listFormation);
				System.out.println("Selectionner l'id de la formation a ajouter");
				int formationToAdd = scan.nextInt();
				Formation formation = formationDao.read(formationToAdd);
				if(formation != null) {
					job.addFormation(formation);
				} else {
					System.out.println(COLOR_RED + "The formation doesn't exist !");
				}
				break;
				
			case 6 :
				System.out.println("Quelle formation souhaitez vous supprimer de votre panier ?");
				int formationToRemove = scan.nextInt();
				job.removeFormation(formationToRemove);
				break;
				
			case 7 :
				System.out.println("CONTENU DU PANIER :");
				String titles = centerString("Id formation") + centerString("Nom de la formation") + 
						centerString("Description de la formation")  + centerString("Prix de la formation") + centerString("QUANTITE");
				System.out.println(titles);
				
				job.getOrderList().forEach(x -> System.out.println(x.getIdFormation() + "--- " 
																	+ x.getNameFormation() + " ---" 
																	+ x.getDescriptionFormation()+ " ----" 
																	+ x.getQuantity() + " ---" 
																	+ x.getPriceFormation()));
				System.out.println("MONTANT DE VOTRE PANIER " + job.getTotal()+"€ \n");
				break;
				
			case 8: 
				if(userStatus ==0 ) {
					System.out.println("Pour valider votre panier vous devez vous connecter \n"
							+"1- Connectez vous : \n"
							+"2- Creation d'un compte \n");
					int connexion = scan.nextInt();
					if(connexion == 1) {
						connection();
					} else {
						System.out.println("Saississez votre login");
						String newUserLog = scan.next();
						System.out.println("Saisissez votre mot de passe");
						String newUserPwd = scan.next();
						if(auth.existLogin(newUserLog)) { 
							System.out.println("Sorry this user already exist");
						} else {
							job.newUser(newUserLog, newUserPwd);
							System.out.println("Utilisateur créé");
						}
					}
					} else {
						
						int idCustomer = newCustomer(userStatus);
						if(idCustomer != 0) {
							int idBasket = job.order(idCustomer);
							if(idBasket != 0) {
								System.out.println("Votre commande a bien été validé, voici votre numéro de commande : "+ idBasket);
								job.clearBasket();
							}
							
						}
						
					}
					break;
					
			case 9:
					connection();
					break;
		
			default:
				System.out.println("Aurevoir !");
				break;
			}
			 }
		} catch(Exception e){
			e.printStackTrace();
		}
			
		}
	
	public static void displayMainMenu() {
		System.out.printf("---------------------------------------------------------%n");
		System.out.printf("Que voulez vous faire ? Entrez le numéro correspondant : %n");
		System.out.printf("---------------------------------------------------------%n");
		System.out.printf("|%-5s |%-40s |%n","1-"," Trier par catégories ");
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("|%-5s |%-40s |%n","2-"," Afficher les formations a distance ");
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("|%-5s |%-40s |%n","3-"," Afficher les formation en présentiel ");
		System.out.printf("--------------------------------------------------%n");;
		System.out.printf("|%-5s |%-40s |%n","4-"," Chercher par mot clé ");
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("|%-5s |%-40s |%n","5-"," Ajouter une formation a mon panier ");
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("|%-5s |%-40s |%n","6-"," Supprimer un élément de mon panier ");
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("|%-5s |%-40s |%n","7-"," Afficher mon panier ");
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("|%-5s |%-40s |%n","8-"," Valider mon panier ");
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("|%-5s |%-40s |%n","9-"," Se Connecter ");
		System.out.printf("--------------------------------------------------%n");
				
	}
	public static  void displayAllFormations(ArrayList<Formation> list) {
		list.forEach(x -> System.out.println( x.getIdFormation() 
				+ "----" + x.getNameFormation() 
				+ "----" +  x.getDescriptionFormation() 
				+ "---" + x.getDurationFormation()
				+ "----" + x.getStatusFormation() 
				+ "---" + x.getPriceFormation() +"€ \n"));
	}
	
	public static void connection() {
		System.out.println("saisissez votre login : ");
		String log = scan.next();
		System.out.println("saisissez votre password : ");
		String pwd = scan.next();
		
		int id = auth.existUser(log,pwd);
		if(id > 0)	{
			
			userStatus = id;
			User a = userDao.read(userStatus);
			System.out.println("Bonjour "+ a.getLoginUser() + " !");
		}
		else {
			System.out.println("login ou password incorrect");
		}
	}
	public static int newCustomer(int idUser) {
		System.out.println("Avez vous déjà un compte client ? saisissez une adresse email valide pour vérifier :");
		String email = scan.next();		
		if(isValidEmail(email)) {	
			Customer customer = auth.existCustomerEmail(email);
			if(customer == null) {
				scan.nextLine();	
				System.out.println("saisissez votre nom :");
				String name = scan.nextLine();
				System.out.println("saisissez votre prénom :");
				String fName = scan.next();					
				System.out.println("saisissez votre tel :");
				String tel = scan.next();		
				scan.nextLine(); 
				System.out.println("saisissez votre adresse :");
				String address = scan.nextLine();
				Customer cust = new Customer(name, fName, email, tel, address, idUser); 
				if(auth.addCustomer(cust))	
					return auth.existCustomerEmail(email).getIdCustomer();
			}
			else {
				System.out.println("Nous allons associer la commande en cours avec le compte client : " + customer);
				return customer.getIdCustomer();
			}
		}
		else System.out.println("vous n'avez pas saisi un email valide");	
		return 0;
	}
	public static boolean isValidEmail(String email) {
		String regExp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z][a-z]+$";	
		return email.matches(regExp);
	}

	public static String centerString(String str) {
		if(str.length() >= MAX_STRING_LENGTH) return str;
		String dest = "                    ";
		int deb = (MAX_STRING_LENGTH - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}

	public static void displayFormation(ArrayList<Formation> list) {
		
		System.out.printf( "|%-5s |%-15s |%-45s |%-10s |%-10s |%-8s |%n", "Id","NAME","DESCRIPTION","DUREE", "STATUS", "PRIX" );
		System.out.printf("----------------------------------------------------------------------------------------------------------%n");
		list.forEach(x ->
		System.out.printf(COLOR_BLACK +"|%-10s |%-15s |%-45s |%-10s |%-10s |%12s |%n",
				x.getIdFormation()%2 ==0 ? COLOR_GREEN_BG + x.getIdFormation()  : COLOR_WHITE_BG + x.getIdFormation(), x.getNameFormation(), x.getDescriptionFormation(), x.getDurationFormation() +" jours", x.getStatusFormation(), x.getPriceFormation()+"€" 	+ COLOR_RESET_BG));
		System.out.printf("----------------------------------------------------------------------------------------------------------%n");
	}

}
