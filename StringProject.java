/**
 *
 */
/**
 * @author jinhui(Evans) liang
 *
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//for words like ex: hash-map
//in that case, my program counts 'hashmap' as one unique words.

//my program just initialized the string in main and use it from there, I can always modify it so that
//it will promtp the user for some input.

//DataStructure i used for this program: array, hash-map
//hash-map for rapid lookup, much more efficient.
public class StringProject {

    public static void main(String[] args) {
        //user input string
        String input = "Rep. Trey Gowdy (R-South Carolina) and Rep. Jim Sensenbrenner (R-Wisconsin), meanwhile, "
                + "challenged Sewell to come up with a scenario in which Apple would cooperate with the authorities on a security back door or to offer its own legislative suggestions.";

        //to reformat the input to alphabet letters only, and storing each word into the array.
        String[] array_words = Reformat_Paragraph(input);

        //create hash table for each unique words
        HashMap<String, Integer> hash_table = new HashMap<String, Integer>();

        //Map all entries to the hashmap
        Mapping_to_HashMap(array_words, hash_table);

        //fast lookup a single word and its appearance
        String fast_lookup = find_word_and_count(hash_table,"Evans");
        System.out.println(fast_lookup);

        //print the result string
        String result = Print_HashMap(hash_table);
        System.out.println(result);

    }

    //takes all the words from input and map each single one into hash_table
    public static void Mapping_to_HashMap(String[] array_words, HashMap<String, Integer> hash_table)
    {
        //go through every word and map to hash map
        for(int i =0;i<array_words.length;i++)
        {
            String word = array_words[i];
            //skip the case when there are "  " (two or more white space together)
            //when used split, it puts these spaces into its own index, so I skipped these index here.
            if (!word.equals("")){
                //very efficient way to look up.
                if(hash_table.containsKey(word) == false)
                    hash_table.put(word, 1);
                else //if it does exit, update the count
                {
                    int count = hash_table.get(word);
                    hash_table.put(word, count+1);
                }
            }
        }
    }

    //an extra function just for fast look up for a word and its appearance
    public static String find_word_and_count(HashMap<String, Integer> hash_table, String word)
    {
        //if it exist, return the word and its appearance
        if(hash_table.containsKey(word) == true)
        {
            return "['"+word+"', "+hash_table.get(word)+"]";
        }
        else //return an error message if doesn't exist.
            return "The word '"+word+"' did not appear in the text";
    }

    //print the hash table
    public static String Print_HashMap(HashMap<String, Integer> hash_table)
    {
        //formatted exactly the way that user asked for
        Iterator<String> iterator = hash_table.keySet().iterator();
        String output = "[";
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            Integer value = hash_table.get(key);
            //this is just for the end of the list, for formatting purposes
            if (iterator.hasNext())
                output += "['"+key+"', "+value+"], ";
            else
                output += "['"+key+"', "+value+"]";
        }
        output +="]";

        return output;
    }

    //returns an array containing all words
    public static String[] Reformat_Paragraph(String input)
    {
        String no_punctuation = Extract_Punctuation(input);
        String lowercase_output = no_punctuation.toLowerCase();
        return lowercase_output.split(" ");
    }
    //gets rid of everything but letters a-z and A-Z
    public static String Extract_Punctuation(String s) {
        Pattern pattern = Pattern.compile("[^a-z A-Z]");
        Matcher matcher = pattern.matcher(s);
        String words = matcher.replaceAll("");
        return words;
    }
}
