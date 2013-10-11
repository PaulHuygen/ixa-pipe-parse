/*
 * Copyright 2013 Rodrigo Agerri

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */


package ixa.pipe.heads;

import java.util.HashMap;

import opennlp.tools.parser.Parse;

/**
 * Class for storing the English head rules associated with parsing according
 * to Michael Collins's PhD Thesis (1999: 236-238). 
 *  
 * 2013/10: Originally based on the HeadRules for English of OpenNLP which read 
 * the rules from a file. We instead harcoded the rules here to code much more 
 * easily the various traversal methods. This hardcoded is originally based on 
 * an implementation of the CollinsHeadFinder.java of Stanford CoreNLP, but we still
 * rely on the Apache OpenNLP API to handle Parse tree traversals and so on. 
 * 
 * The deployment of these rules in the AbstractHeadFinder.java class is a complete
 * reimplementation of the opennlp.tools.parser.HeadRules.en.HeadRules.java class. 
 * 
 * This reimplementation allows now to coherently traverse the tree to mark the head nodes 
 * via 6 different methods (see AbstractHeadFinder). 
 * 
 * @author ragerri 
 * 
 */
public class CollinsHeadFinder extends AbstractHeadFinder {

  
  public CollinsHeadFinder() {
    super();
    
    headRules = new HashMap<String, String[][]>();
    // This version from Collins' diss (1999: 236-238)
    headRules.put("ADJP", new String[][]{{"left", "NNS", "QP", "NN", "$", "ADVP", "JJ", "VBN", "VBG", "ADJP", "JJR", "NP", "JJS", "DT", "FW", "RBR", "RBS", "SBAR", "RB"}} );
    headRules.put("ADVP", new String[][]{{"right", "RB", "RBR", "RBS", "FW", "ADVP", "TO", "CD", "JJR", "JJ", "IN", "NP", "JJS", "NN"}});
    headRules.put("CONJP", new String[][]{{"right", "CC", "RB", "IN"}});
    headRules.put("FRAG", new String[][]{{"right"}});
    headRules.put("INTJ", new String[][]{{"left"}});
    headRules.put("LST", new String[][]{{"right", "LS", ":"}});
    headRules.put("NAC", new String[][]{{"left", "NN", "NNS", "NNP", "NNPS", "NP", "NAC", "EX", "$", "CD", "QP", "PRP", "VBG", "JJ", "JJS", "JJR", "ADJP", "FW"}});
    headRules.put("NX", new String[][]{{"left"}}); 
    headRules.put("PP", new String[][]{{"right", "IN", "TO", "VBG", "VBN", "RP", "FW"}});
    headRules.put("PRN", new String[][]{{"left"}});
    headRules.put("PRT", new String[][]{{"right", "RP"}});
    headRules.put("QP", new String[][]{{"left", "$", "IN", "NNS", "NN", "JJ", "RB", "DT", "CD", "NCD", "QP", "JJR", "JJS"}});
    headRules.put("RRC", new String[][]{{"right", "VP", "NP", "ADVP", "ADJP", "PP"}});
    headRules.put("S", new String[][]{{"left", "TO", "IN", "VP", "S", "SBAR", "ADJP", "UCP", "NP"}});
    headRules.put("SBAR", new String[][]{{"left", "WHNP", "WHPP", "WHADVP", "WHADJP", "IN", "DT", "S", "SQ", "SINV", "SBAR", "FRAG"}});
    headRules.put("SBARQ", new String[][]{{"left", "SQ", "S", "SINV", "SBARQ", "FRAG"}});
    headRules.put("SINV", new String[][]{{"left", "VBZ", "VBD", "VBP", "VB", "MD", "VP", "S", "SINV", "ADJP", "NP"}});
    headRules.put("SQ", new String[][]{{"left", "VBZ", "VBD", "VBP", "VB", "MD", "VP", "SQ"}});
    headRules.put("UCP", new String[][]{{"right"}});
    headRules.put("VP", new String[][]{{"left", "TO", "VBD", "VBN", "MD", "VBZ", "VB", "VBG", "VBP", "AUX", "AUXG", "VP", "ADJP", "NN", "NNS", "NP"}});
    headRules.put("WHADJP", new String[][]{{"left", "CC", "WRB", "JJ", "ADJP"}});
    headRules.put("WHADVP", new String[][]{{"right", "CC", "WRB"}});
    headRules.put("WHNP", new String[][]{{"left", "WDT", "WP", "WP$", "WHADJP", "WHPP", "WHNP"}});
    headRules.put("WHPP", new String[][]{{"right", "IN", "TO", "FW"}});
    headRules.put("X", new String[][]{{"right"}}); // crap rule
    headRules.put("NP", new String[][]{{"rightdis", "NN", "NNP", "NNPS", "NNS", "NX", "POS", "JJR"}, {"left", "NP"}, {"rightdis", "$", "ADJP", "PRN"}, {"right", "CD"}, {"rightdis", "JJ", "JJS", "RB", "QP"}});
    headRules.put("TYPO", new String[][] {{"left"}});
    headRules.put("EDITED", new String[][] {{"left"}});
    headRules.put("XS", new String[][] {{"right", "IN"}});
  }
    
  
  // TODO
  protected void postOperationFix(Parse headNode, Parse[] children) { 
    
  }


 
}

