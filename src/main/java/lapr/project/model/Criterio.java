package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diana Silva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum Criterio implements Serializable{
    
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
