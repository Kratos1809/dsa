public class Stringpattern{

    public static void main(String[] args){
        System.out.println(skip("bcaaadaah"));
    }

    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if(ch == 'a'){
            skip(p, up.substring(1));
        }
        else{
            skip(p + ch, up.substring(1));
        }
    }

    static String skippp(String up){
        if(up.isEmpty()){
            return "";
        }

        char ch = up.charAt(0);

        if(ch == 'a'){
            return skippp(up.substring(1));
        }
        else{
            return ch + skippp(up.substring(1));
        }
    }
}