import java.util.*;
public class Main {
    operations op=new operations();
    helper hel=new helper();

    public void hashit(String input) {
        String[] h_hex = {"0x6a09e667", "0xbb67ae85", "0x3c6ef372", "0xa54ff53a", "0x510e527f", "0x9b05688c", "0x1f83d9ab", "0x5be0cd19"};
        String[] h=new String[h_hex.length];
        String[]  k_hex = {"0x428a2f98", "0x71374491", "0xb5c0fbcf", "0xe9b5dba5", "0x3956c25b", "0x59f111f1", "0x923f82a4",
        "0xab1c5ed5", "0xd807aa98", "0x12835b01", "0x243185be", "0x550c7dc3", "0x72be5d74", "0x80deb1fe", 
        "0x9bdc06a7", "0xc19bf174", "0xe49b69c1", "0xefbe4786", "0x0fc19dc6", "0x240ca1cc", "0x2de92c6f", 
        "0x4a7484aa", "0x5cb0a9dc", "0x76f988da", "0x983e5152", "0xa831c66d", "0xb00327c8", "0xbf597fc7", 
        "0xc6e00bf3", "0xd5a79147", "0x06ca6351", "0x14292967", "0x27b70a85", "0x2e1b2138", "0x4d2c6dfc", 
        "0x53380d13", "0x650a7354", "0x766a0abb", "0x81c2c92e", "0x92722c85", "0xa2bfe8a1", "0xa81a664b", 
        "0xc24b8b70", "0xc76c51a3", "0xd192e819", "0xd6990624", "0xf40e3585", "0x106aa070", "0x19a4c116", 
        "0x1e376c08", "0x2748774c", "0x34b0bcb5", "0x391c0cb3", "0x4ed8aa4a", "0x5b9cca4f", "0x682e6ff3", 
        "0x748f82ee", "0x78a5636f", "0x84c87814", "0x8cc70208", "0x90befffa", "0xa4506ceb", "0xbef9a3f7", 
        "0xc67178f2"};

        String[] k=new String[k_hex.length];
        for (int i=0;i<h_hex.length;i++){
            h[i]=(hel.hexToBinary(h_hex[i].substring(2)));
        }
        for(int i=0;i<k_hex.length;i++) {
            k[i]=(hel.hexToBinary(k_hex[i].substring(2)));
        }
        hel.tomessagesplit((hel.padit(hel.Translate(input))));

        String s0,s1;
        for (int i=16;i<=63;i++){
              s0=(op.Xor(op.Xor(hel.Rotr(hel.w[i-15],7),(hel.Rotr(hel.w[i-15],18))),hel.shr(hel.w[i-15],3)));
              s1=(op.Xor(op.Xor(hel.Rotr(hel.w[i-2],17),(hel.Rotr(hel.w[i-2],19))),hel.shr(hel.w[i-2],10)));
              hel.w[i]=op.Add(op.Add(hel.w[i-16],s0),op.Add(hel.w[i-7],s1));
        }

        String a=h[0];
        String b=h[1];
        String c=h[2];
        String d=h[3];
        String e=h[4];
        String f=h[5];
        String g=h[6];
        String hh=h[7];
        String temp1,temp2;
        String S0,S1;
        String ch;
        String maj;
       
        for(int i=0;i<64;i++){
            S1=op.Xor(hel.Rotr(e,6),op.Xor(hel.Rotr(e,11),hel.Rotr(e,25)));
            ch=op.Xor(op.and(e,f),op.and(op.not(e),g));
            temp1=op.Add(op.Add(op.Add(op.Add(hh, S1), ch), k[i]), hel.w[i]);
            S0=op.Xor(hel.Rotr(a,2),op.Xor(hel.Rotr(a,13),hel.Rotr(a,22)));
            maj=op.Xor(op.Xor(op.and(a,b),op.and(a,c)),op.and(b,c));
            temp2=op.Add(S0, maj);
            hh=g;
            g=f;
            f=e;
            e=op.Add(d, temp1);
            d=c;
            c=b;
            b=a;
            a=op.Add(temp1, temp2);
        }

        h[0]=op.Add(h[0],a);
        h[1]=op.Add(h[1],b);
        h[2]=op.Add(h[2],c);
        h[3]=op.Add(h[3],d);
        h[4]=op.Add(h[4],e);
        h[5]=op.Add(h[5],f);
        h[6]=op.Add(h[6],g);
        h[7]=op.Add(h[7],hh);
        String[] h_hex_new=new String[h.length];
        String hashed="";
        for(int i=0;i<h.length;i++){
            h_hex_new[i]=hel.BintoHex(h[i]);
        }
        for(int i=0;i<h.length;i++){
            hashed=hashed+h_hex_new[i];
        }
        System.out.println(hashed.toUpperCase());



    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        Main m=new Main();
        System.out.println("Enter the Option\n1.Random String\n2.Input");
        String random,input;
        int choice=in.nextInt();
        if(choice ==1){
        random=m.hel.randomString(15)+2%10;
        System.out.print(random+"  : ");
        m.hashit(random);
        }
        else{
        System.out.println("Enter String :");
        in.nextLine();
        input = in.nextLine();
        m.hashit(input);
        } 

        in.close();
        

    }
    
}
