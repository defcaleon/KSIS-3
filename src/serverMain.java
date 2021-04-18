public class serverMain {

    public  static void  main(String[] args){
        try {
            Server server=new Server();
            System.out.println(server.getStringIP());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
