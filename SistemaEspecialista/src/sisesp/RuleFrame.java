package sisesp;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * The <code>RuleFrame</code> class implements the GUI and application logic
 * that demonstrates boolean and fuzzy rule inferencing.
 *
 * @author Joseph P. Bigus
 * @author Jennifer Bigus
 *
 * @copyright Constructing Intelligent Agents using Java (C) Joseph P. Bigus and
 * Jennifer Bigus 2001
 *
 */
public class RuleFrame extends JFrame {

    BorderLayout borderLayout1 = new BorderLayout();
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu FileMenu = new JMenu();
    JMenuItem StartMenuItem = new JMenuItem();
    JMenuItem ResetMenuItem = new JMenuItem();
    JMenuItem ExitMenuItem = new JMenuItem();
    JMenu DataMenu = new JMenu();
    JMenuItem DefaultsMenuItem = new JMenuItem();
    JMenuItem SetValuesMenuItem = new JMenuItem();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTextArea traceTextArea = new JTextArea();
    JRadioButton forwardChainRadioButton = new JRadioButton();
    JRadioButton backChainRadioButton = new JRadioButton();
    ButtonGroup buttonGroup = new ButtonGroup();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JTextField resultTextField = new JTextField();
    FlowLayout flowLayout1 = new FlowLayout();
    BorderLayout borderLayout2 = new BorderLayout();
    JMenu HelpMenu = new JMenu();
    JMenuItem AboutMenuItem = new JMenuItem();
    JMenu RuleBaseMenu = new JMenu();

    //----adicionado
    JRadioButtonMenuItem InvestimentosRadioButtonMenuItem = new JRadioButtonMenuItem();

    ButtonGroup ruleBaseButtonGroup = new ButtonGroup();
    JComboBox GoalComboBox = new JComboBox();
    static RuleBase currentRuleBase;
    //adicionado
    static BooleanRuleBase investimentos;

    /**
     * Creates a <code>RuleFrame</code> object.
     *
     */
    public RuleFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {            
            //adicionado
            investimentos = new BooleanRuleBase("Investimentos Tabajara");
            investimentos.setDisplay(traceTextArea);
            initInvestimentosRuleBase(investimentos);
           
            currentRuleBase = investimentos;

            jbInit();

            // initialize textAreas and list controls            
            InvestimentosRadioButtonMenuItem_actionPerformed(null);
            currentRuleBase.displayRules(traceTextArea);
            currentRuleBase.displayVariables(traceTextArea);
            forwardChainRadioButton.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the GUI controls.
     *
     * @throws Exception if an error occurred during initialization
     *
     */
    private void jbInit() throws Exception {
        this.getContentPane().setLayout(borderLayout1);
        this.setSize(new Dimension(680, 700));
        
        this.setTitle("Rule Application");
        FileMenu.setText("File");
        StartMenuItem.setText("Start");
        StartMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StartMenuItem_actionPerformed(e);
            }
        });
        ResetMenuItem.setText("Reset");
        ResetMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResetMenuItem_actionPerformed(e);
            }
        });
        ExitMenuItem.setText("Exit");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExitMenuItem_actionPerformed(e);
            }
        });
        DataMenu.setText("Data");
        DefaultsMenuItem.setText("Use default values");
        DefaultsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultsMenuItem_actionPerformed(e);
            }
        });
        SetValuesMenuItem.setText("Set values...");
        SetValuesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SetValuesMenuItem_actionPerformed(e);
            }
        });
        jPanel1.setPreferredSize(new Dimension(400, 100));
        jPanel1.setLayout(null);
        forwardChainRadioButton.setText("Forward chain");
        forwardChainRadioButton.setBounds(new Rectangle(19, 19, 103, 25));
        backChainRadioButton.setText("Backward chain");
        backChainRadioButton.setBounds(new Rectangle(17, 48, 154, 25));
        jPanel2.setLayout(borderLayout2);
        HelpMenu.setText("Help");
        AboutMenuItem.setText("About");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AboutMenuItem_actionPerformed(e);
            }
        });

        RuleBaseMenu.setText("RuleBase");
        //--adicionado
        InvestimentosRadioButtonMenuItem.setText("Investimentos");
        InvestimentosRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InvestimentosRadioButtonMenuItem_actionPerformed(e);
            }
        });

        
        ruleBaseButtonGroup.add(InvestimentosRadioButtonMenuItem);
        //--adicionado

        GoalComboBox.setBounds(new Rectangle(170, 51, 145, 23));
        buttonGroup.add(forwardChainRadioButton);
        buttonGroup.add(backChainRadioButton);
        jLabel1.setText("Goal");
        jLabel1.setBounds(new Rectangle(171, 28, 106, 17));
        jLabel2.setText("Result");
        jLabel2.setBounds(new Rectangle(313, 29, 103, 17));
        resultTextField.setBounds(new Rectangle(312, 51, 176, 21));
        jPanel3.setLayout(flowLayout1);
        flowLayout1.setHgap(20);
        jMenuBar1.add(FileMenu);
        jMenuBar1.add(RuleBaseMenu);
        jMenuBar1.add(DataMenu);
        jMenuBar1.add(HelpMenu);
        FileMenu.add(StartMenuItem);
        FileMenu.addSeparator();
        FileMenu.add(ResetMenuItem);
        FileMenu.addSeparator();
        FileMenu.add(ExitMenuItem);
        DataMenu.add(DefaultsMenuItem);
        DataMenu.add(SetValuesMenuItem);
        this.getContentPane().add(jPanel1, BorderLayout.NORTH);
        jPanel1.add(forwardChainRadioButton, null);
        jPanel1.add(backChainRadioButton, null);
        jPanel1.add(resultTextField, null);
        jPanel1.add(GoalComboBox, null);
        jPanel1.add(jLabel1, null);
        jPanel1.add(jLabel2, null);
        this.getContentPane().add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(jScrollPane1, BorderLayout.CENTER);
        jScrollPane1.getViewport().add(traceTextArea, null);
        this.getContentPane().add(jPanel3, BorderLayout.SOUTH);
        HelpMenu.add(AboutMenuItem);
        RuleBaseMenu.add(InvestimentosRadioButtonMenuItem);
        //adicioando
        setJMenuBar(jMenuBar1);
    }

    /**
     * Closes or repaints the window.
     *
     * @param e the WindowEvent object generated when window is closed or
     * activated
     *
     */
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
        if (e.getID() == WindowEvent.WINDOW_ACTIVATED) {
            e.getWindow().repaint();
        }
    }
  
    //adicionado
    private void initInvestimentosRuleBase(BooleanRuleBase rb) {
        
        //-VARIAVEIS  
        //---------------------------------------------------------------------------------------------------       
        //experiencia com investimento
        RuleVariable experiencia = new RuleVariable(rb, "experiencia");
        experiencia.setLabels("iniciante intermediaria avancada");
        experiencia.setPromptText("Qual a sua experiencia como investidor?");
        
        //rsico
        RuleVariable risco = new RuleVariable(rb, "risco");
        risco.setLabels("baixo moderado elevado");
        risco.setPromptText("Esta disposto a correr algum risco?");

        //perfil
        RuleVariable perfil = new RuleVariable(rb, "perfil");
        perfil.setLabels("arrojado moderado conservador");
        perfil.setPromptText("Qual o seu perfil de investidor?");
        
        //objetivo
        RuleVariable objetivo = new RuleVariable(rb, "objetivo");
        objetivo.setLabels("acumular-patrimonio aposentadoria aquisicao-bens viagem");
        objetivo.setPromptText("Qual o objetivo para o seu investimento?");

        // valor inicial
        RuleVariable ticket = new RuleVariable(rb, "ticket");
        ticket.setLabels("nenhum pequeno(<=30) medio(<100) grande(>100)");
        ticket.setPromptText("Qual o valor de inicio do investimento (ticket)?");
                
        //valor mensal deposito
        RuleVariable valorMensal = new RuleVariable(rb, "valor-mensal");
        valorMensal.setLabels("pequeno(<1000) medio(<10000) grande(>10000)");        
        valorMensal.setPromptText("Qual o valor mensal que vc poderá contribuir para seu investimento?");
        
        //liquidez
        RuleVariable liquidez = new RuleVariable(rb, "liquidez");
        liquidez.setLabels("curto-prazo medio-prazo longo-prazo");
        liquidez.setPromptText("Qual o prazo de resgate para o seu investimento?");        
        
        //tipo investimento
        RuleVariable investimento = new RuleVariable(rb, "investimento");
        investimento.setLabels("Renda-Fixa Investimento-CDB Previdencia-Privada Mercado-Acoes Tesouro-Direto Poupanca Dolar");
        investimento.setPromptText("Qual o tipo de Investimento?");
        
        // CONDIÇÕES
        Condition cEquals = new Condition("=");
        Condition cNotEquals = new Condition("!=");
        Condition cLessThan = new Condition("<");

        //---------------------------------------------------------------------------------------------------           
        
               
        //----Regras genericas para o Perfis
        //---------------------------------------------------------------------------------------------------
        Rule Conservador = new Rule(rb, "conservador", new Clause[]{
                                                            new Clause(risco, cEquals, "baixo"),             
                                                            new Clause(experiencia, cEquals, "iniciante")},
                                                       new Clause(perfil, cEquals, "conservador"));           
                
        Rule Moderado = new Rule(rb, "moderado", new Clause[]{
                                                        new Clause(risco, cEquals, "moderado"),             
                                                        new Clause(experiencia, cEquals, "intermediaria")},
                                                 new Clause(perfil, cEquals, "moderado"));     
                
        Rule Arrojado = new Rule(rb, "arrojado", new Clause[]{
                                                        new Clause(risco, cEquals, "elevado"),             
                                                        new Clause(experiencia, cEquals, "avancada")},
                                                 new Clause(perfil, cEquals, "arrojado"));                     
        //---------------------------------------------------------------------------------------------------
                

        //objetivo 
        //---------------------------------------------------------------------------------------------------
        //AquisicaoBens 
        Rule AquisicaoBens = new Rule(rb, "aquisicao-bens", new Clause[]{
                                                                new Clause(valorMensal, cEquals, "pequeno(<1000)"),
                                                                new Clause(liquidez, cEquals, "curto-prazo")},                                                                                
                                                            new Clause(objetivo, cEquals, "aquisicao-bens"));              
                
        //Aposentadoria 
        Rule Aposentadoria = new Rule(rb, "aposentadoria", new Clause[]{
                                                                new Clause(valorMensal, cNotEquals, "pequeno(<1000)"),
                                                                new Clause(liquidez, cEquals, "longo-prazo")},
                                                           new Clause(objetivo, cNotEquals, "aposentadoria"));              
                
        //AcumularPatrimonio 
        Rule AcumularPatrimonio = new Rule(rb, "acumular-patrimonio", new Clause[]{
                                                                            new Clause(valorMensal, cEquals, "grande(>10000)"),
                                                                            new Clause(liquidez, cNotEquals, "curto-prazo")},                
                                                                      new Clause(objetivo, cEquals, "acumular-patrimonio"));        

        //Viagem
        Rule Viagem = new Rule(rb, "viagem", new Clause[]{
                                                new Clause(valorMensal, cEquals, "medio(<10000)"),
                                                new Clause(liquidez, cEquals, "medio-prazo")},                
                                             new Clause(objetivo, cEquals, "viagem"));        

        //---------------------------------------------------------------------------------------------------
        
        
        /// Regras referentes ao objetivo rpincipal do sistema
        /// 
        //POUPANÇA
        //---------------------------------------------------------------------------------------------------        
        Rule Poupanca = new Rule(rb, "Popupanca", new Clause[]{
                                                        new Clause(perfil, cEquals, "conservador"),        
                                                        new Clause(objetivo, cEquals, "aquisicao-bens"),
                                                        new Clause(ticket, cEquals, "nenhum")},
                                                  new Clause(investimento, cEquals, "Poupanca"));              
        //---------------------------------------------------------------------------------------------------        
        
        // RENDA FIXA
        Rule RendaFixa = new Rule(rb, "Renda-Fixa", new Clause[]{
                                                        new Clause(perfil, cNotEquals, "arrojado"), // diferente de arrojado
                                                        new Clause(objetivo, cEquals, "acumular-patrimonio"),
                                                        new Clause(ticket, cEquals, "medio(<100)")},
                                                    new Clause(investimento, cEquals, "Renda-Fixa"));  
        //---------------------------------------------------------------------------------------------------                        
               
        // TESOURO DIRETO
        //---------------------------------------------------------------------------------------------------                
        Rule TesouroDireto = new Rule(rb, "Tesouro-Direto", new Clause[]{
                                                                new Clause(perfil, cNotEquals, "arrojado"), // diferente de arrojado
                                                                new Clause(objetivo, cEquals, "acumular-patrimonio"),                                                        
                                                                new Clause(ticket, cEquals, "pequeno(<=30)")},
                                                            new Clause(investimento, cEquals, "Tesouro-Direto"));                        
        //---------------------------------------------------------------------------------------------------                        
        
        //INESTIMENTO CDB
        //---------------------------------------------------------------------------------------------------                
        Rule InvestimentoCDB = new Rule(rb, "Investimento-CDB", new Clause[]{
                                                                    new Clause(perfil, cNotEquals, "conservador"),  // diferente de conservador
                                                                    new Clause(objetivo, cEquals, "acumular-patrimonio"),                                                           
                                                                    new Clause(ticket, cEquals, "grande(>100)")},
                                                                new Clause(investimento, cEquals, "Investimento-CDB"));                      
        //---------------------------------------------------------------------------------------------------                        
                        
        //PREVIDENCIA PRIVADA
        //---------------------------------------------------------------------------------------------------                
        Rule PrevidenciaPrivada = new Rule(rb, "Previdencia-Privada", new Clause[]{
                                                                            new Clause(perfil, cNotEquals, "conservador"), // diferente de conservador
                                                                            new Clause(objetivo, cEquals, "aposentadoria"),                                                            
                                                                            new Clause(ticket, cEquals, "pequeno(<=30)")},
                                                                      new Clause(investimento, cEquals, "Previdencia-Privada"));                   
        //---------------------------------------------------------------------------------------------------                
                
        //MERCADO DE AÇÕES
        //---------------------------------------------------------------------------------------------------                        
        Rule MercadoAcoes = new Rule(rb, "Mercado-Acoes", new Clause[]{
                                                                new Clause(perfil, cEquals, "arrojado"),
                                                                new Clause(objetivo, cNotEquals, "aposentadoria"),
                                                                new Clause(ticket, cEquals, "medio(<100)")},
                                                          new Clause(investimento, cEquals, "Mercado-Acoes"));                           
        //---------------------------------------------------------------------------------------------------                        
                                
        //DOLAR
        //---------------------------------------------------------------------------------------------------                        
        Rule Dolar = new Rule(rb, "Dolar", new Clause[]{
                                                new Clause(perfil, cEquals, "arrojado"),
                                                new Clause(objetivo, cEquals, "viagem"),
                                                new Clause(ticket, cEquals, "grande(>100)")},
                                           new Clause(investimento, cEquals, "Dolar"));    
        //---------------------------------------------------------------------------------------------------                        
    }
        

    //adicionado
    private void demoInvestimentosFC(BooleanRuleBase rb) {
        traceTextArea.append("\n --- Setting Values for Investimentos ForwardChain Demo ---\n ");

        // poderia ser Poupança
        rb.setVariableValue("investimento", null);                
        rb.setVariableValue("perfil", "conservador");                
        rb.setVariableValue("liquidez", "imediato");        
        rb.displayVariables(traceTextArea);
    }

    //adicionado
    private void demoInvestimentosBC(BooleanRuleBase rb) {
        traceTextArea.append("\n --- Setting Values for Investimentos BackwardChain Demo ---\n ");

        // poderia ser Poupança
        rb.setVariableValue("investimento", null);                
        rb.setVariableValue("perfil", "conservador");                        
        rb.setVariableValue("liquidez", "imediato");        
        rb.displayVariables(traceTextArea);
    }

    /**
     * Starts the inferencing cycle.
     *
     * @param e the ActionEvent object generated when start was selected
     *
     */
    void StartMenuItem_actionPerformed(ActionEvent e) {
        String goal = null;
        RuleVariable goalVar = (RuleVariable) GoalComboBox.getSelectedItem();

        traceTextArea.append("\n --- Starting Inferencing Cycle --- \n");
        currentRuleBase.displayVariables(traceTextArea);
        if (forwardChainRadioButton.isSelected() == true) {
            currentRuleBase.forwardChain();
        }
        if (backChainRadioButton.isSelected() == true) {
            if (currentRuleBase instanceof BooleanRuleBase) {
                if (goalVar == null) {
                    traceTextArea.append("Goal variable is not defined!");  // give warning
                } else {
                    goal = goalVar.getName();
                }
            }
            currentRuleBase.backwardChain(goal);
        }
        currentRuleBase.displayVariables(traceTextArea);
        traceTextArea.append("\n --- Ending Inferencing Cycle --- \n");

        // report back chain results if any
        if (goalVar != null) {
            Object result = goalVar.getValue();

            if (result == null) {
                result = "null";
            }
            resultTextField.setText((String) result);
        }
    }

    /**
     * Resets the current rule base.
     *
     * @param e the ActionEvent object generated when reset was selected
     *
     */
    void ResetMenuItem_actionPerformed(ActionEvent e) {

        // Clear the text for TextArea
        traceTextArea.setText("");
        currentRuleBase.reset();
    }

    /**
     * Exits the application.
     *
     * @param e the ActionEvent object generated when exit was selected
     *
     */
    void ExitMenuItem_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    /**
     * Displays a dialog and allow the user to set variable values.
     *
     * @param e the ActionEvent object generated when the set values was
     * selected
     */
    void SetValuesMenuItem_actionPerformed(ActionEvent e) {

        // open the dialog to set values in the rulebase
        if (currentRuleBase instanceof BooleanRuleBase) {
            BooleanRuleBaseVariablesDialog dlg = new BooleanRuleBaseVariablesDialog(this, "Set Boolean Rule Base Variables", true);

            dlg.setRuleBase((BooleanRuleBase) currentRuleBase);
            Point loc = this.getLocation();

            dlg.setLocation(loc.x + 20, loc.y + 20);
            dlg.show();
        } else {

            // allow user to set fuzzy rule variables
            FuzzyRuleBaseVariablesDialog dlg = new FuzzyRuleBaseVariablesDialog(this, "Set Fuzzy Rule Base Variables", true);

            dlg.setRuleBase((FuzzyRuleBase) currentRuleBase);
            Point loc = this.getLocation();

            dlg.setLocation(loc.x + 20, loc.y + 20);
            dlg.show();
        }
    }

    /**
     * Sets the defaults.
     *
     * @param e the ActionEvent object generated when default was selected
     *
     */
    void DefaultsMenuItem_actionPerformed(ActionEvent e) {

        // set all rulebase values to their default (demo?) values
        if (forwardChainRadioButton.isSelected()) {
            //adicioando
            if (currentRuleBase == investimentos) {
                demoInvestimentosFC((BooleanRuleBase) currentRuleBase);
            }

        } else {
            //adicioando
            if (currentRuleBase == investimentos) {
                demoInvestimentosBC((BooleanRuleBase) currentRuleBase);
            }
        }
    }

    /**
     * Changes the context from one rule base to another and clears the text
     * areas.
     */
    void switchRuleBase() {
        traceTextArea.setText("");  // clear the text area
        resultTextField.setText("");
        currentRuleBase.reset();    // reset the rule base
        currentRuleBase.displayRules(traceTextArea);
        currentRuleBase.displayVariables(traceTextArea);
        if (GoalComboBox.getItemCount() > 0) {
            GoalComboBox.removeAllItems();
        }
        Vector goalVars = currentRuleBase.getGoalVariables();

        for (int i = 0; i < goalVars.size(); i++) {
            GoalComboBox.addItem(goalVars.elementAt(i));
        }
    }

    /**
     * Displays the About dialog.
     *
     * @param e the ActionEvent object generated when About was selected
     *
     */
    void AboutMenuItem_actionPerformed(ActionEvent e) {
        AboutDialog dlg = new AboutDialog(this, "About Rule Application", true);
        Point loc = this.getLocation();

        dlg.setLocation(loc.x + 50, loc.y + 50);
        dlg.show();
    }

    //adicioando 
    void InvestimentosRadioButtonMenuItem_actionPerformed(ActionEvent e) {
        currentRuleBase = investimentos;
        setTitle("Rule Application - Investimentos Tabajara");
        switchRuleBase();
        GoalComboBox.setSelectedItem(((BooleanRuleBase) currentRuleBase).getVariable("investimento"));
    }
    
}
