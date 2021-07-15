import java.util.Stack;
/**
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  Lab 3 - Exercise 2 + Bonus
 * Author:      Leyre Sanchez Vinuela
 * Description: Class that checks if an xml string is well formed.
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
 */

public class XMLChecker {

    /**
     * Check if a string is a well-formed xml
     * @param xml - the string to be checked
     * @return true if the string is a well-formed xml, false if not
     */
    public static boolean wellformedXML(String xml){

        // Local variables
        String tag = ""; // accumulates the current tag without the reserved characters
        String root = ""; // stores the root tag
        boolean isBeginTag = false; // indicates that we're in a begin tag: <tag> or <tag/>
        boolean isCloseTag = false; // indicates if the tag is a close tag: </tag> or <tag/>
        Stack<String> stack = new Stack<>(); /* a stack of tags that that are not close tags:
                                                they get removed by their corresponding close tags.
                                                The tags are stored without reserved characters */

        // Invalid case: null or empty xml argument
        if (xml == null || xml.length() == 0){
            return false;
        }

        // For each character in the string:
        for(int i=0; i<xml.length(); i++){
            char ch = xml.charAt(i);

            // If the character is < (indicates the start of a new begin tag):
            if (ch == '<'){

                // Invalid case: < in the middle of a tag
                if (!tag.isEmpty()){
                    return false;
                }

                // Else: it means that we're entering a new begin tag
                isBeginTag = true;
            }


            // Invalid case: the stack is empty and we're not in a tag
            else if (!isBeginTag && stack.isEmpty()){
                return false;
            }


            // If the character is / (close tag marker):
            else if (ch == '/'){

                // Invalid case: double slash or slash outside a tag
                if (isCloseTag || !isBeginTag){
                    return false;
                }

                // Mark the tag as close tag: </ (normal close tag) or <tag/ (begin and close tag)
                isCloseTag = true;

                // If the tag is empty, it's a normal close tag
                if (tag.isEmpty()){
                    isBeginTag = false;
                }
            }


            // If the character is >:
            else if (ch == '>'){

                // Invalid case: the root tag is empty <rootTag/>
                if (isBeginTag && isCloseTag && stack.isEmpty()){
                    return false;
                }

                // If it's an opening tag:
                if (isBeginTag) {

                    // If it's a self contained tag of the type <tag/>, reset all the values and continue
                    if (isCloseTag) {
                        tag = "";
                        isBeginTag = false;
                        isCloseTag = false;
                        continue;
                    }

                    // Invalid tag: <> or same tag as the root
                    if (tag.isEmpty() || tag.equals(root)) {
                        return false;
                    }

                    // If the tag contains whitespaces:
                    if (tag.contains(" ")) {

                        // check that the attributes are well formed
                        if (!wellFormedAttributes(tag)) {
                            return false;
                        }
                        // store the tag without attributes
                        tag = tag.substring(0, tag.indexOf(" "));
                    }
                    // If it's the first opening tag, set it as the the root
                    if (stack.isEmpty()) {
                        root = tag;
                    }

                    // Add the tag to the top of the stack
                    stack.push(tag);

                    // Reset the variables
                    isBeginTag = false;
                    tag = "";
                }

                // If it's a closing tag...
                else if (isCloseTag){
                    // Invalid cases: </> or closing tag doesn't match with opening tag at the top of the stack or contains whitespace
                    if (tag.isEmpty() || !tag.equals(stack.peek()) || tag.contains(" ")){
                        return false;
                    }

                    //...remove the top of the stack
                    stack.pop();

                    // Reset the variables
                    isCloseTag = false;
                    tag = "";

                }
                // Invalid case: > used outside a tag
                else{
                    return false;
                }
            }

            // For any other character...
            else {
                // ...add it to the tag if we're in a begin or close tag
                if (isBeginTag || isCloseTag) {
                    tag += ch;
                }
            }
        }
        return stack.isEmpty() && tag.isEmpty();
    }

    /**
     * Helper method to check if a tag with attributes is well formed
     * @param tag - the tag with attributes to be checked
     * @return true if the tag with attributes is well formed, false if not
     */
    private static boolean wellFormedAttributes(String tag){
        // Split the tag by its whitespaces and get a list: [tag, att1, att2,..., attn]
        String[] attributes = tag.split(" ", -1);

        // For each attribute of the list
        for (int i=1; i< attributes.length; i++){
            String att = attributes[i];

            // Check that the attribute contains a key and a value
            if (!att.contains("=") || att.startsWith("=")|| !att.endsWith("\"")){
                return false;
            }
            int mid = att.indexOf("=");

            // Check that the first part is well formed
            if (att.substring(0, mid).contains("=") || att.substring(0, mid).contains("\"")){
                return false;
            }

            // Check that the second part is well formed
            if (att.charAt(mid+1)!='"' || att.substring(mid+1).length()<2 ||
                    att.substring(mid+2, att.length()-1).contains("=") ||
                    att.substring(mid+2, att.length()-1).contains("\"") ){
                return false;
            }
        }
        return true;
    }

}


