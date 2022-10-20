public class postfix {
    public static void main(String[] args){
        String k;
        String a = "a+b*c+d-e/f";
        k = postfix(a);
        System.out.println(k);
    }
    public static String postfix(String a){
        stack s;
        String result;
        result = new String();
        char[] arr = a.toCharArray();
        int size = arr.length;
        s = new stack(size);
        for(int i = 0;i<size;i++){
            char letter = arr[i];
            switch(letter){
                case '+':
                case '-':
                    if(s.peek() == '*' || s.peek() == '/'){
                        while(!s.isEmpty()) result += s.pop();
                        s.push(letter);
                    }
                    else s.push(letter);
                    break;
                case '*':
                case '/':
                case '(':
                case '{':
                    s.push(letter);
                    break;
                case ')':
                    while(s.peek() != '(') result += s.pop();
                    if(s.peek() == ' ') return null;
                    s.pop();
                    if(!s.isEmpty()) result += s.pop();
                    break;
                case '}':
                    while(s.peek() != '{') result += s.pop();
                    if(s.peek() == ' ') return null;
                    s.pop();
                    if(!s.isEmpty()) result += s.pop();
                    break;
                default :
                    result += letter;

            }
        }
        while(!s.isEmpty()) result += s.pop();
        return result;
    }
}
