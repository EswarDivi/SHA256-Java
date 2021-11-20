public class operations {
    public String Add(String a, String b) { 
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0;i--,j--){
            int sum = carry + (i >= 0 ? a.charAt(i) - '0':0) + (j >= 0 ? b.charAt(j) - '0' : 0);
            sb.append(sum%2);
            carry =sum / 2;
        }
        
        sb.reverse();
        return sb.toString();
    }
    public String Xor(String a,String b) {
        String temp="";
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i)==b.charAt(i)) {
                temp+="0";
            }
            else {
                temp+="1";
            }
        }
        return temp;
    }
    public String not(String a) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return sb.toString();
    }
    public String and(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '1' && b.charAt(i) == '1') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}
