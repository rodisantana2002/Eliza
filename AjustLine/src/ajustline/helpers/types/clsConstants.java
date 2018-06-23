package ajustline.helpers.types;

/**
 * @author Rodolfo
 */
public class clsConstants {
    //Constantes de tipos de dados
    public static final int D_BOOLEAN    = 1;
    public static final int D_CHAR       = 2;
    public static final int D_BYTE       = 3;
    public static final int D_SHORT      = 4;
    public static final int D_INT        = 5;
    public static final int D_LONG       = 6;
    public static final int D_FLOAT      = 7;
    public static final int D_DOUBLE     = 8;
    public static final int D_STRING     = 9;
    public static final int D_DATETIME   = 10;
    public static final int D_ARRAYLIST  = 11;
    public static final int D_OBJECT     = 12;
    public static final int D_HORA       = 13;

    //Constantes de tipos de operações com dados
    public static final int TO_INCLUIR   = 1;
    public static final int TO_ALTERAR   = 2;
    public static final int TO_CONSULTAR = 3;
    public static final int TO_EXCLUIR   = 4;
    public static final int TO_PESQUISAR = 5;

    //Constantes de tipos de mensagens
    public static final int MSG_INFORMACAO   = 1;
    public static final int MSG_EXCLAMACAO   = 2;
    public static final int MSG_INTERROGACAO = 3;
    public static final int MSG_ERRO         = 4;

    //constantes de tipos de componentes
    public static final int COMP_JPANEL             = 1;
    public static final int COMP_JLABEL             = 2;
    public static final int COMP_JSEPARATOR         = 3;
    public static final int COMP_JBUTTON            = 4;
    public static final int COMP_JRADIO_BUTTON      = 5;
    public static final int COMP_JCHECKBOX          = 6;
    public static final int COMP_JCOMBO             = 7;
    public static final int COMP_JLIST              = 8;
    public static final int COMP_JTEXT_FIELD        = 9;
    public static final int COMP_JTEXT_AREA         = 10;
    public static final int COMP_JPASSWORD_FIELD    = 11;
    public static final int COMP_JFORMAT_TEXT_FIELD = 12;
    public static final int COMP_DATE_FORMATED      = 13;
    public static final int COMP_JFILTRO_DINAMICO   = 14;
    public static final int COMP_JLISTA_DINAMICA    = 15;
    public static final int COMP_DATE_PERIODO       = 16;
    public static final int COMP_DATE_SIMPLE        = 17;
    public static final int COMP_HORA_SIMPLE        = 18;

    public static final String COMP_JTABLE = "javax.swing.JTable";
    public static final String COMP_JFORMATTED_TEXT_FIELD = "javax.swing.JFormattedTextField";

    //Constantes Booleanas
    public static final int BLN_SIM      = 1;
    public static final int BLN_NAO      = 0;

    //Constantes Eventos KEY
    public static final int KEY_ENTER    = 10;
    public static final int KEY_DELETE   = 127;    
    public static final int KEY_INSERT   = 155;    
    public static final int KEY_ESC      = 27;
    //------ Teclas de Funcoes
    public static final int KEY_F1       = 112;
    public static final int KEY_F2       = 113;
    public static final int KEY_F3       = 114;
    public static final int KEY_F4       = 115;
    public static final int KEY_F5       = 116;
    public static final int KEY_F6       = 117;
    public static final int KEY_F7       = 118;
    public static final int KEY_F8       = 119;
    public static final int KEY_F9       = 120;
    public static final int KEY_F10      = 121;
    public static final int KEY_F11      = 122;
    public static final int KEY_F12      = 123;
    
    //Constantes para Tratar Lista e Combos
    public static final String LIST_ORIGEM_LISTA  = "0";
    public static final String LIST_ORIGEM_CLASSE = "1";

    //constantes para identificar tipos de componentes
    public static final int TP_CONDICAO = 1;
    public static final int TP_VISIVEL = 2;
    public static final int TP_CHAVE = 3;

    //constantes para o numero de regs a serem carregados pelas listas genericas
    public static final int ROWS_DEFAULT        = 0;  //Todos
    public static final int ROWS_MINIMO         = 50;
    public static final int ROWS_MAXIMO         = 300;

    //Constantes para componentes
    public static final String STR_NOME_CRIAR_COMPONENT   = "criarComponent";
    public static final String STR_NOME_SET_COMPONENT     = "setComponent";
    public static final String STR_NOME_SET_OBJ_COMPONENT = "setobjComponente";
    public static final String STR_NOME_SET_OBJ_DADOS     = "setobjDados";
    public static final String STR_NOME_GET_VALOR         = "getValor";
    public static final String STR_NOME_OBTER_DADOS       = "obterDados";
    public static final String STR_NOME_GRAVAR_DADOS      = "Gravar";
    public static final String STR_NOME_REMOVER_DADOS     = "Excluir";
    public static final String STR_NOME_SET_FIX_FILTER    = "setFixFilter";
    public static final String STR_NOME_GET_FIX_FILTER    = "getFixFilter";    
    public static final String STR_NOME_SET_ADV_FILTER    = "setAdvancedFilter";
    public static final String STR_NOME_GET_ADV_FILTER    = "getAdvancedFilter";

    //constantes para tratamento de datas
    public static final int DT_ULT_DIA_MES[]       = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static final int DT_MES_FEV             = 2;
    public static final int DT_ULT_DIA_MES_FEV_BIX = 29;
    public static final int DT_ANO_MINIMO          = 1900;
    
    //Cores Internas
    public static final int COR_PRETO       = 1;    
    public static final int COR_BRANCO      = 2;
    public static final int COR_AZUL        = 3;
    public static final int COR_AZUL_CLARO  = 4;
    public static final int COR_AMARELO     = 5;
    public static final int COR_VERDE       = 6;
    public static final int COR_VERMELHO    = 7;    
    public static final int COR_CINZA       = 8;    
    public static final int COR_AZUL_CEU    = 9;

    
    //Caminho arquivo XML de configuracao
    public static final String ARQ_XML_CAMINHO  = "XML/";    
    public static final String ARQ_XML_EXTENSAO = ".xml";        

    //Status da Data de Lancamento
    public static final int STATUS_OK = 1;
    public static final int STATUS_OCORRENCIA = 2;
    public static final int STATUS_REGULARIZADO = 3;
    
    //Tipo de Sinais para identificar Horario
    public static final String SINAL_POSITIVO = "+";
    public static final String SINAL_NEGATIVO = "-";
    
    //caminho arquivo JS
    public static final String ARQ_JS_VALIDA_FILTRO="js/validFiltro.js";
    
    //nome dos objetos de bancos de dados
    public static final String OBJETO_TABLE = "TABLE";
    public static final String OBJETO_SYSTEM_TABLE = "SYSTEM TABLE";
    public static final String OBJETO_VIEW = "VIEW";
    public static final String OBJETO_FUNCTION = "FUNCTION";
    public static final String OBJETO_PROCEDURE = "PROCEDURE";
    public static final String OBJETO_TRIGGER = "TRIGGER";
    public static final String OBJETO_DEPENDENCIA = "TABLE";
    public static final String OBJETO_DEPENTENTE = "TABLE";
    
    public static final String TAB_ESTRUTURA = "Estrutura";
    public static final String TAB_SQL = "SQL";
    public static final String TAB_DEPENDENCIA = "Dependencia";
    public static final String TAB_DEPENDENTE = "Dependente";
    public static final String TAB_DADOS = "Dados";
    public static final String TAB_PROC_PARAMETROS = "Proc. Parametros";
    public static final String TAB_FUNC_PARAMETROS = "Func.Parametros";   
    
    public static final short OBJETO_TYPE_FUNCTION = 2;   
    
    public static final int DOMINIO_BD = 1; //tipo de banco de dados            
    public static final int BD_ORACLE = 1;
    public static final int BD_SQLSERVER = 2;
    public static final int BD_DERBY = 3;
    public static final int BD_POSTGRESQL = 4;
    public static final int BD_MYSQL = 5; 
    public static final int BD_DB2 = 6;    
    
    public static final int DOMINIO_LOOK_FEEL = 2; //tipo de Visões
    public static final int LOOK_FEEL_METAL = 1;
    public static final int LOOK_FEEL_NIMBUS =2;            
    public static final int LOOK_FEEL_WINDOWS = 3;           
    public static final int LOOK_FEEL_WINDOWS_CLASSIC = 4; 
    public static final int LOOK_FEEL_CDE_MOTIF = 5;    
    
    //Constantes referentes a operadores
    public static final int DOMINIO_OPER_CONDICAO = 3; //tipo de Visões
    public static final int OPER_IGUAL = 1;
    public static final int OPER_IGUAL_MAIOR = 2;
    public static final int OPER_IGUAL_MENOR = 3;
    public static final int OPER_MAIOR = 4;
    public static final int OPER_MENOR = 5;
    public static final int OPER_DIFERENTE = 6;
    public static final int OPER_COMPARACAO = 7;
    public static final int OPER_ISNULL = 8;
    public static final int OPER_INTERVALO = 9;

    //Constantes referentes a operadores
    public static final int DOMINIO_OPER_LOGICA = 4; //tipo de Visões
    public static final int OPER_EMPTY = 1;   
    public static final int OPER_AND = 2;   
    public static final int OPER_OR = 3;   
    
    //Constantes referentes a tipo de lancamento
    public static final int DOMINIO_TIPO_LANC = 5; 
    public static final int TIPO_LANC_ENT01 = 1;  
    public static final int TIPO_LANC_SDA01 = 2;      
    public static final int TIPO_LANC_ENT02 = 3;  
    public static final int TIPO_LANC_SDA02 = 4;  
    public static final int TIPO_LANC_SDA_ESP = 5;      
    public static final int TIPO_LANC_ENT_ESP = 6;  
    
    //constantes referentes a tipo de ocorrencia
    public static final int DOMINIO_TIPO_OCOR = 6;     
    public static final int TIPO_OCOR_FALTA = 1;  
    public static final int TIPO_OCOR_FALTA_ABONADA = 2;  
    public static final int TIPO_OCOR_ATESTADO = 3;  
    public static final int TIPO_OCOR_FOLGA_ABONADA = 4;  
    public static final int TIPO_OCOR_ESQUECIMENTO = 5;      
    public static final int TIPO_OCOR_ATRASO = 6;
    public static final int TIPO_OCOR_COMP_HORAS_POSITIVAS = 7;  
    public static final int TIPO_OCOR_COMP_HORAS_NEGATIVAS = 8;  
        
    public static final String[] LSTCONDICOES = {" = ", " >= ", " <= ", " > ", " < ", " <> ", " LIKE ", " IS NULL ", " IS NOT NULL ", " IN "};
    public static final String[] LSTOPERADORES = {" AND ", " OR "};
    public static final String[] LSTPREFIXARQUIVOS = {"CAD","CAM", "COM", "CTR", "EST", 
                                                      "FAC", "FAT", "FEC", "GER", "LIB", "LOG", 
                                                      "PAD", "PAG", "PRO", "PSO", "SEG", 
                                                      "TAB", "TRG", "UPR", "UNM", "UTI"};
    public static final String[] LSTTIPOSARQUIVOS = {"TODOS", "SA", "SC", "SR", "TA", "TC", "TR"};
    public static final String[] LSTFREQUENCIA = {"01-2015", "02-2015", "03-2015", "04-2015",
                                                  "05-2015", "06-2015", "07-2015", "08-2015",
                                                  "09-2015", "10-2015", "11-2015", "12-2015" };
    
    public static final String METODO_NAME_REORGANIZAR_CONSULTA="ajustarColunas";    
    public static final String METODO_NAME_INCLUIR_CODICAO="incluirCondicao";
    public static final String METODO_NAME_EXCLUIR_CONDICAO="excluirCondicao";
    public static final String METODO_NAME_EDITAR_CONDICAO="editarCondicao";
    public static final String METODO_NAME_REFRESH_CONDICAO="atualizarConsulta";
    
    public static final String METODO_NAME_SAIR="finalizarObjeto";
    public static final String METODO_NAME_INICIAR_CAPTURA="iniciarCaptura";
    public static final String METODO_NAME_TERMINAR_CAPTURA="finalizarCaptura";
    
    public static final int NUM_COLUNAS_HARD=10;
    public static final int NUM_CAMPOS_EXIBE_FILTRO=24;    
    
    public static final String CONEXOES_ALL = "TODAS";
    public static final String HORA_MIN_ALMOCO = "01:00";    
}
