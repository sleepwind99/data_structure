public class Assignment52 {
    public static void main(String[] args){
        HTable hash = new HTable();
        for(int i = 0; i < 20; i++){
            hash.insert(i,Integer.toString(i));
        }
        for(int i = 0; i < 20; i++){
            System.out.println(hash.query(i));
        }
        for(int i = 0; i < 20; i++){
            if(hash.delete(i+2)) System.out.println("deleted!");
            else System.out.println("Not deleted!");
        }
        for(int i = 0; i < 20; i++){
            System.out.println(hash.query(i));
        }
    }
}
