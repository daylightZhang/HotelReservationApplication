package api;

public class AdminMenu extends MainMenu {

    public AdminMenu(){
        super();
    }
    /**
     * this method displays the admin menu, extends to the MainMenu
     */
    public void display() {
        System.out.println("==========Admin Menu==========");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
        System.out.println("==============================");
        System.out.println("Enter your option:");
    }

    public void optionProcess(int option) {
        switch (option){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;

            case 4:

                break;

            case 5:
                this.setRunning(false);                  // exit the admin menu
                break;

        }
    }
}
