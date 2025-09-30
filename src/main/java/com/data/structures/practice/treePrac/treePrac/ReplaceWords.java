package com.data.structures.practice.treePrac.treePrac;

import java.util.*;

public class ReplaceWords {
    public static void main(String[] args) {
       // String[] dictionary = {"cat","bat","rat"};
       // String[] dictionary = {"catt","cat","bat","rat"};
        //String[] dictionary = {"e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw"};
        String[] dictionary = {"a","a","b","c"};
       // String[] dictionary = {"a"};

    //String sentence = "the cattle was rattled by the battery";
    //String sentence = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
    String sentence = "aadsfasf absbs bbab cadsfafs";
    //String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
   // System.out.println(replaceWords(Arrays.stream(dictionary).toList(), sentence));
    System.out.println(replaceWords2(Arrays.stream(dictionary).toList(), sentence));
    }

    /*Summary Table
    Step	Time	Space
    Insert dictionary into TST	O(n · L)	O(n · L)
    Split sentence	O(S)	O(S)
    Search prefixes for m words	O(m · W)	O(1) extra
    Build output	O(S)	O(S)
    Total	O(n·L + m·W)	O(n·L + S)*/
    static class TSTNode{

        char ch;
        TSTNode left, middle, right;
        String word;
        TSTNode(char ch){
            this.ch = ch;
        }
    }

    static class TSTree{
        TSTNode root;

        void insert(String key){
            root=insert( key, root, 0);
        }

        TSTNode insert(String s, TSTNode node, int i){
            char c = s.charAt(i);
            if(node == null) node = new TSTNode(c);
            if(c< node.ch){
                node.left = insert( s, node.left, i);
            }else if(c> node.ch){
                node.right = insert( s, node.right, i);
            }else{
                if(i < s.length()-1){
                    node.middle = insert( s, node.middle, i+1);
                }else{
                    node.word= s;
                }
            }
            return node;
        }

        boolean search(String key){
            TSTNode node = search(key, root, 0);
            return node!=null && node.word != null;
        }

        TSTNode search(String s, TSTNode node, int i){
            if(node == null)return null;
            char c = s.charAt(i);
            if(c<node.ch){
                return search(s, node.left, i);
            }else if(c > node.ch){
                return search(s, node.right, i);
            }else{
                if(i< s.length()-1){
                    return search(s, node.middle,i+1);
                }
            }
            return node;
        }

        TSTNode searchShortestPrefix(String s, TSTNode node, int i, Map<String, TSTNode> store){
            if(node == null)return null;
            if(store.containsKey(s.substring(0, i+1)))return store.get(s.substring(0, i+1));
            char c = s.charAt(i);
            if(node.ch == c && node.word!=null)return node;
            if(c<node.ch){
                return searchShortestPrefix(s, node.left, i, store);
            }else if(c > node.ch){
                return searchShortestPrefix(s, node.right, i, store);
            }else{
                if(i< s.length()-1){
                    return  searchShortestPrefix(s, node.middle,i+1, store);
                }
            }
            return node;
        }

        /*TSTNode searchShortestPrefix(String s, TSTNode node, int i){
            if(node == null)return null;
            if(node.word!=null)return node;
            char c = s.charAt(i);
            if(c<node.ch){
                TSTNode l= searchShortestPrefix(s, node.left, i);
                if(l != null && l.word != null)return l;
            }else if(c > node.ch){
                TSTNode r = searchShortestPrefix(s, node.right, i);
                if(r != null && r.word != null)return r;
            }else{
                if(i< s.length()-1){
                   TSTNode m=  searchShortestPrefix(s, node.middle,i+1);
                    if(m != null && m.word != null)return m;
                }
            }
            return node;
        }*/

        List<String> findAllPrefix(String prefix){
            if(root ==null)return null;
            List<String> res = new ArrayList<>();
            TSTNode node = search(prefix, root, 0);
            if (node == null) return res;
            if(node.word != null)res.add(node.word);
            collect(   res,  node.middle);
            return res;
        }

        void collect(List<String> res, TSTNode node){
            if(node == null)return;
            if(node.word != null)res.add(node.word);
            collect(   res,  node.left);
            collect(   res,  node.right);
            collect(   res,  node.middle);
        }

        String  findAllPrefixAndReplace(String prefix, String sentence){
            if(root ==null)return null;
            List<String> res = new ArrayList<>();
            TSTNode node = search(prefix, root, 0);
            if (node == null) return sentence;
            if(node.word != null){
                sentence=sentence.replace(node.word, prefix);
                res.add(node.word);
            }
            //sentence =collectWithReplace(   res,  node.left, sentence, prefix);
            //sentence =collectWithReplace(   res,  node.right, sentence, prefix);
            sentence =collectWithReplace(   res,  node.middle, sentence, prefix);
            return sentence;
        }

        String collectWithReplace(List<String> res, TSTNode node, String sentence,String prefix){
            if(node == null)return sentence;
            if(node.word != null){
                sentence=sentence.replace(node.word, prefix);
                res.add(node.word);
            }
            sentence =collectWithReplace(   res,  node.left, sentence, prefix);
            sentence =collectWithReplace(   res,  node.right, sentence, prefix);
            sentence = collectWithReplace(   res,  node.middle, sentence, prefix);
            return sentence;
        }

    }
    public static String replaceWords(List<String> dictionary, String sentence) {

        TSTree tsTree = new TSTree();
        String[] wl = sentence.split(" ");
        for(String w:wl){
            tsTree.insert(w);
        }
        List<List<String>> res = new ArrayList<>();
       //Collections.sort(dictionary);
        for(String w:dictionary) {
            //sentence=tsTree.findAllPrefixAndReplace(w, sentence);
            List<String> pre = tsTree.findAllPrefix(w);
            System.out.println(pre);

            for(int i=pre.size()-1;i>=0;i--) {
                System.out.println(pre.get(i)+ " :: "+w);
                if(w.length()==1){
                    sentence=sentence.replaceAll(pre.get(i)+" ", w+" ");
                    sentence=sentence.replaceAll(" "+pre.get(i), " "+w);
                }else{
                    sentence=sentence.replaceAll(pre.get(i), w);
                }


                System.out.println(sentence);
            }
        }
        return sentence;
    }
    public static String replaceWords2(List<String> dictionary, String sentence) {

        Map<String, TSTNode> store= new HashMap<>();

        TSTree tsTree = new TSTree();
        for(String d:dictionary){
            tsTree.insert(d);
        }
        List<List<String>> res = new ArrayList<>();
        String[] words = sentence.split(" ");
        //Collections.sort(dictionary);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<words.length;i++) {
            String w = words[i];
            //sentence=tsTree.findAllPrefixAndReplace(w, sentence);
            TSTNode node = tsTree.searchShortestPrefix(w, tsTree.root,0, store);
            if(node != null && node.word != null) {
                sb.append(node.word);
                System.out.println(w+"  :: "+node.word);
            }
            else{
                sb.append(w);
            }
            if(i<words.length-1) sb.append(" ");
        }
        return sb.toString();
    }

}
