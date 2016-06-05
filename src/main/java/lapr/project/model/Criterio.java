package lapr.project.model;

/**
 *
 * @author Diana Silva
 */
public enum Criterio {
    
    CONHECIMENTO{
        @Override
        public String toString(){
            return "Conhecimento do FAE sobre o tema da exposição: 0-5 ";
        }
    },
    
    ADEQUACAO_CANDIDATURA{
        @Override
        public String toString(){
            return "Adequação da candidatura à exposição: 0-5 ";
        }
    },
    ADEQUACAO_DEMONSTRACAO{
        @Override
        public String toString(){
            return "Adequação da candidatura às demonstrações: 0-5 ";
        }
    },
    ADEQUACAO_CONVITES{
        @Override
        public String toString(){
            return "Adequação do número de convites por candidatura: 0-5 ";
        }
    },
    RECOMENDACAO_GLOBAL{
        @Override
        public String toString(){
            return "Recomendação global: 0-5 ";
        }
    }

}
