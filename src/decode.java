import java.util.*;
public class decode{
    static String wrd;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int i,j,l;
        char x;
        System.out.println("ENTER KEYWORD: ");
        wrd = in.nextLine().toUpperCase();
        System.out.println("ENTER TEXT TO BE DECODED: ");
        String dec = in.nextLine().toUpperCase();
        //removing spaces
        wrd = spaRep(wrd);
        char alpha[] = new char[26];
        for(i=65,j=0;j<26 && i<=90;i++,j++){
            alpha[j] = (char)i;
        }//makes an alphabet array.
        //System.out.println(Arrays.toString(alpha));
        char enc[] = new char[26];
        l = wrd.length();
        for(i=0;i<l;i++){
            enc[i] = wrd.charAt(i);
        }
        for (i=l,j=65;i<26&&j<=90;i++,j++){
            if(wrd.indexOf((char)j)<0){
                enc[i] = (char)j;
            }
            else{
                i=i-1;
                continue;
            }
        }
        //System.out.println(Arrays.toString(enc));
        String out = "";
        for(i = 0;i<dec.length();i++){
            x = dec.charAt(i);
            for(j=0;j<26;j++){
                if(x == enc[j]){
                    out +=alpha[j];
                }
                else if(x==' '){
                    out = out + " ";
                    break;
                }
            }
        }
        System.out.print("DECODED TEXT: ");
        System.out.print(out);
    }
    static String spaRep(String a){
        int l = a.length();
        String abc = "";
        int i,j;char x,y;
        for(i = 0;i<l;i++){
            x = a.charAt(i);
            if(x==' '){
                continue;
            }
            abc = abc + x;
        }

        l=abc.length();
        String xyz = "";
        for(i=0;i<l;i++){
            x = abc.charAt(i);
            if(xyz.indexOf(x)<0){
                xyz += x;
            }
        }
        return xyz;
    }
}