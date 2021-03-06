
/**
 * Lisa Nordquist lino0425
 * Har samarbetat med Charlotte Hjalmarsson chhj2260
 * [Handledning, f�rel�sningar, kursboken]
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Dog> dogList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Auction> auctionList = new ArrayList<>();
    private int auctionNumber = 1;

    private void sortdogList() {
        boolean switched = true;
        Dog tempDog;
        while (switched) {
            switched = false;
            for (int i = 1; i < dogList.size(); i++) {
                if (dogList.get(i - 1).getTailLength() < dogList.get(i).getTailLength()
                        || Double.compare(dogList.get(i - 1).getTailLength(), dogList.get(i).getTailLength()) == 0
                        && dogList.get(i - 1).getName().compareTo(dogList.get(i).getName()) > 0) {
                    tempDog = dogList.get(i - 1);
                    dogList.set(i - 1, dogList.get(i));
                    dogList.set(i, tempDog);
                    switched = true;
                }
            }
        }
    }

    private void initialize() {
        System.out.println("Welcome!");

        System.out.println("Print: register new dog");
        System.out.println("Print: increase age");
        System.out.println("Print: list dogs");
        System.out.println("Print: remove dog");
        System.out.println("Print: register new user");
        System.out.println("Print: list users");
        System.out.println("Print: remove user");
        System.out.println("Print: start auction");
        System.out.println("Print: list auctions");
        System.out.println("Print: list bids");
        System.out.println("Print: make bid");
        System.out.println("Print: close auction");
        System.out.println("Print: exit");

    }

    private void runCommandLoop() {
        String command;
        do {
            command = readCommand();
            handleCommand(command);
        } while (!command.equals("exit"));
    }

    private String readCommand() {
        System.out.println("Choose a command from list above:");
        String command = input.nextLine();
        return command;
    }

    private void handleCommand(final String command) {
        switch (command) {
            case "register new dog":
                registerNewDog();
                break;

            case "increase age":
                increaseAge();
                break;

            case "list dogs":
                listDogs();
                break;

            case "remove dog":
                removeDog();
                break;

            case "register new user":
                registerNewUser();
                break;

            case "list users":
                listUsers();
                break;

            case "remove user":
                removeUser();
                break;

            case "start auction":
                startAuction();
                break;

            case "list auctions":
                listAuctions();
                break;

            case "close auction":
                closeAuction();
                break;

            case "list bids":
                listBids();
                break;

            case "make bid":
                makeBid();
                break;

            case "exit":
                System.out.println("You chose exit");
                break;

            default:
                System.out.println("Error.");
        }
    }

    private String stringFix(final String string, final String message) {
        String result = string.toLowerCase().trim();
        while (result.isEmpty()) {
            System.out.println("Error: the name can't be empty");
            System.out.println(message);
            result = string.toLowerCase().trim();
        }
        return result;

    }

    private void registerNewDog() {
        registerNewDog(null, null, null, null);
    }

    public void registerNewDog(final String name, final String breed, final Integer age, final Integer weight) {
        System.out.println("You chose register new dog");

        System.out.println("Enter name: ");
        String _name = (name == null ? stringFix(input.nextLine(), "Enter name: ") : name);

        System.out.println("Enter breed: ");
        String _breed = (breed == null ? stringFix(input.nextLine(), "Enter breed: ") : breed);

        System.out.println("Enter age: ");
        int _age = (age == null ? input.nextInt() : age);
        if (age == null) {
            input.nextLine();
        }

        System.out.println("Enter weight: ");
        int _weight = (weight == null ? input.nextInt() : weight);
        if (weight == null) {
            input.nextLine();
        }

        dogList.add(new Dog(_name, _breed, _age, _weight));
    }

    private void increaseAge() {
        System.out.println("You chose increase age");
        System.out.println("Enter name of dog: ");
        String name = stringFix(input.nextLine(), "Enter name of dog: ");
        for (Dog d : dogList) {
            if (d.getName().equalsIgnoreCase(name)) {
                d.incrementAge();
                System.out.println(name + " is now one year older");
                return;
            }
        }
        System.out.println("Error: No dog with that name in the register.");

    }

    private void listDogs() {
        System.out.println("You chose list dogs");

        if (dogList.isEmpty()) {
            System.out.println("Error: no dogs in register");
        } else {
            sortdogList();
            System.out.println("Shortest taillength of dog: ");
            double tailLength = input.nextDouble();
            input.nextLine();
            System.out.println("The following dogs has such a large tail: ");
            for (Dog d : dogList) {
                if (d.getTailLength() >= tailLength) {
                    System.out.println(d);
                }
            }
        }
    }

    private void removeDog() {
        System.out.println("You chose remove dog");
        System.out.println("Name of dog you want to remove: ");
        String name = stringFix(input.nextLine(), "Name of dog you want to remove: ");
        for (Dog d : dogList) {
            if (d.getName().equalsIgnoreCase(name)) {
                dogList.remove(d);
                System.out.println("Dog with that name is removed.");
                return;
            }
        }
        System.out.println("Error: No dog with that name in the register.");
    }

    private void registerNewUser() {
        registerNewUser(null);
    }

    public void registerNewUser(final String username) {
        System.out.println("You chose register new user");

        System.out.println("Name: ");
        String name = (username == null ? stringFix(input.nextLine(), "Name: ") : username);
        User user = new User(name);
        userList.add(user);

        System.out.println(name + " added to the register");

    }

    private void listUsers() {
        System.out.println("You chose list users");
        for (User u : userList) {
            System.out.println(u);
        }
        if (userList.isEmpty()) {
            System.out.println("Error: no users in register");
        }
    }

    private void removeUser() { // g�ra s� att hundarna/auktionerna ocks� tas bort
        System.out.println("You chose remove user");
        System.out.println("Enter the name of the user: ");
        String name = stringFix(input.nextLine(), "Enter the name of the user: ");
        for (User u : userList) {
            if (u.getName().equalsIgnoreCase(name)) {
                userList.remove(u);
                return;
            }
            System.out.println(name + "is removed from the register");
        }
        System.out.println("Error: no such user");
    }

    private void startAuction() {
        startAuction(null);
    }

    public void startAuction(final String dogname) {
        System.out.println("You chose start auction");
        System.out.println("Enter the name of the dog: ");
        String name = dogname == null ? stringFix(input.nextLine(), "Enter the name of the dog: ") : dogname;
        for (Dog d : dogList) {
            if (d.getName().equalsIgnoreCase(name)) {

                if (d.isOwned()) {
                    System.out.println("Error: this dog already has an owner");
                    return;
                }
                for (Auction a : auctionList) {
                    if (a.getDogName().equalsIgnoreCase(name)) {
                        System.out.println("Error: this dog is already up for auction.");
                        return;
                    }
                }
                Auction newAuction = new Auction(d, auctionNumber++);
                auctionList.add(newAuction);
                System.out.println(name + " has been put up for auction # " + newAuction.getAuctionNumber());
                return;
            }
        }
        System.out.println("Error: no such dog");
    }

    private void listAuctions() {
        System.out.println("You chose list auctions");
        for (Auction a : auctionList) {
            System.out.println(a);
        }
        if (auctionList.isEmpty()) {
            System.out.println("Error: no auctions in progress");
        }
    }

    private void listBids() {
        System.out.println("You chose list bids");
        System.out.println("Enter the name of the dog: ");
        String name = stringFix(input.nextLine(), "Enter the name of the dog: ");

        for (Auction a : auctionList) {
            if (a.getDogName().equalsIgnoreCase(name)) {
                ArrayList<Bid> bidList = a.getBid();
                if (bidList.isEmpty()) {
                    System.out.println("No bids registred yet for this auction");
                }
                for (Bid b : bidList) {
                    System.out.println("Here are the bids for this auction");
                    System.out.println(b.getBidder().getName() + " " + b.getOffer() + " kr");

                }
            } else {
                System.out.println("Error: this dog is not up for auction");
            }

        }

    }

    public boolean makeBid(final String username, final String dogname, final Integer bid) {

        System.out.println("You chose make bid");
        System.out.println("Enter the name of the user: ");
        String userName = username == null ? stringFix(input.nextLine(), "Enter the name of the user: ") : username;
        User user = null;
        for (User u : userList) {
            if (userName.equals(u.getName())) {
                user = u;
                break;
            }
        }
        if (user == null) {
            System.out.println("Error: no such user");
            return false;
        }

        System.out.println("Enter the name of the dog: ");
        String dogName = dogname == null ? stringFix(input.nextLine(), "Enter the name of the dog: ") : dogname;
        Dog dog = null;
        for (Dog d : dogList) {
            if (dogName.equals(d.getName())) {
                dog = d;
                break;
            }
        }
        if (dog == null) {
            System.out.println("Error: no such dog");
            return false;
        }

        Auction auction = null;
        for (Auction a : auctionList) {
            if (a.getDog().equals(dog)) {
                auction = a;
                break;
            }
            if (auction == null) {
                System.out.println("Error: dog is not up for auction");
                return false;
            }
        }

        if (auction == null) {
            System.out.println("Error: auction not started");
            return false;
        }

        System.out.println("Amount to bid(min " + ((auction.getTopBid() + 1)) + ") :"); // funkar ej

        int topBid = 0;
        do {
            if (bid == null) {
                topBid = input.nextInt();
                input.nextLine();
            } else {
                topBid = bid;
            }

            if (topBid < (auction.getTopBid() + 1)) {
                System.out.println("Error: bid too low");
                if (bid != null) {
                    return false;
                }
            }

        } while (topBid < (auction.getTopBid() + 1));
        auction.addBid(new Bid(user, topBid));
        System.out.println("Bid made");

        return true;
    }

    private void makeBid() {
        makeBid(null, null, null);
    } // n�got som �r fel n�r man avslutar en aktion, n�sta aktion som startas f�r nr
    // 2 ist�llet f�r 1

    private void closeAuction() {
        System.out.println("You chose close auction");
        System.out.println("Enter the name of the dog: ");
        String name = stringFix(input.nextLine(), "Enter the name of the dog: ");

        Auction auction = null;
        for (Auction a : auctionList) {
            if (a.getDog().getName().equals(name)) {
                auction = a;
                break;
            }

        }
        if (auction == null) {
            System.out.println("Error: this dog is not up for auction");
            return;
        }

        if (auction.isBidListEmpty()) {
            System.out.println("The auction is closed. No bids were made for " + name);
        } else {
            Bid winningBid = auction.getHighestBid();
            winningBid.getBidder().addDog(auction.getDog());
            auction.getDog().setOwner(winningBid.getBidder());
            System.out.println("The auction is closed. The winning bid was " + winningBid.getOffer()
                    + "kr and was made by " + winningBid.getBidder().getName());
        }

        auctionList.remove(auction);
    }

    private void closeDown() {
        System.out.println("Goodbye!");
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.initialize();
        program.runCommandLoop();
        program.closeDown();
    }

}