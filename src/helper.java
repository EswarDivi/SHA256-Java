public class helper {
    String[] w=new String[64];
    public  String Translate(String str) {
        char[] ch=str.toCharArray();
        String toBinary="";
        for(int i=0;i<str.length();i++) {
            toBinary+="00000000".substring(Integer.toBinaryString(ch[i]).length())+Integer.toBinaryString(ch[i]);
        }

        return toBinary;
        
    }
    public  String padit(String value) {
        int len=value.length();
        
        int topad=448-len-1;
        String zeros="";

        for(int i=0;i<topad;i++) {
            zeros+="0";
        }
        String boole=Integer.toBinaryString(value.length());
        
        
        String last="0000000000000000000000000000000000000000000000000000000000000000".substring(boole.length())+boole;
        
        return value+"1"+zeros+last;
        
    }
    public  void tomessagesplit(String message) {
        for(int i=0,j=0;i<message.length();i=i+32,j=j+1) {
            w[j]=message.substring(i, i+32);
            
        }
    }
    public String hexToBinary(String hex) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < hex.length(); i++) {
            String bin = Integer.toBinaryString(Integer.parseInt(hex.charAt(i) + "", 16));
            sb.append(String.format("%4s", bin).replace(' ', '0'));
        }
        return sb.toString();
    }

    public String BintoHex(String a) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length(); i += 4) {
            String bin = a.substring(i, i + 4);
            sb.append(Integer.toHexString(Integer.parseInt(bin, 2)));
        }
        return sb.toString();
    }


    public String Rotr(String value,int n) {
        String temp="";
        int index=value.length()-n;
        temp=value.substring(index,value.length())+value.substring(0,index);

        return temp;
    }

    public String shr(String value,int n) {
        String zero="";
        for(int i= 0; i < n; i++) {
            zero+="0";
        }
        int index=value.length()-n;
        return zero+value.substring(0,index);


    }
     
    public  String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        int[] num={65,97};
        for(int i = 0; i < len; i++){
            sb.append((char)((int)(Math.random() * 26) + num[(int)(Math.random()*2)]));
             }
        return sb.toString();
    }



    

}
