package lapr.project.model;

/**
 *
 * @author Diana Silva
 */
public enum Criterio {
    
    CONHECIMENTO{
        @Override
        public String toString(){
            return "Conhecimento do FAE sobre o tema da exposição:";
        }
    },
    
    ADEQUACAO_CANDIDATURA{
        @Override
        public String toString(){
            return "Adequação da candidatura à exposição:";
        }
    },
    ADEQUACAO_DEMONSTRACAO{
        @Override
        public String toString(){
            return "Adequação da candidatura às demonstrações:";
        }
    },
    ADEQUACAO_CONVITES{
        @Override
        public String toString(){
            return "Adequação do número de convites por candidatura:";
        }
    },
    RECOMENDACAO_GLOBAL{
        @Override
        public String toString(){
            return "Recomendação global: ";
        }
    }

}
