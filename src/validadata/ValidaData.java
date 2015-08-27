//** Graduando: Geovane Alves de Oliveira  --  Matrícula: 110232

package validadata;

public class ValidaData {

        boolean valid = false; 

        public static int DiaEsperado(String dtesperada, int ano_bi, String dtinicio, int diainicio) {
               int[] dias_mes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
               int dia = diainicio;

               int anodesejado = Integer.parseInt(dtesperada.substring(6,10));
               if (ValidaBissesto(ano_bi, anodesejado)){
                    dias_mes[1] = (dias_mes[1]) + 1;
                }
               if (!ValidaData(dias_mes, dtesperada)) {
                    dia = -1;
                }
               if (!ValidaData(dias_mes, dtinicio)) {
                    dia = -1;
                }
               if (diainicio < 0 || diainicio > 6) {
                    dia = -1;
                }

               if (dia != -1) {
                   int diferdatas = DiferDatas(dtesperada, dtinicio);
                   if (diferdatas < 0) {
                        for (int i = 0; i > diferdatas; i--) {
                            if (dia > 0) {
                                dia--;
                            } else {
                                dia = 6;
                            }
                        }

                    } else if (diferdatas > 0) {
                        for (int i = 0; i < diferdatas; i++) {
                            if (dia > 6) {
                                dia = 0;
                            } else {
                                dia++;
                            }
                        }
                    }
                }
                return dia;
        }

         public static boolean ValidaBissesto(int ano_bi, int ano_desejada){ /*Valida o ano bissesto*/
             boolean anoBi = false;
             boolean valid = false;
                if(ano_bi < 1){
                   System.out.println(-1); 
                }

                if(ano_desejada < ano_bi){
                    valid = true;

                    while(ano_desejada < ano_bi){
                       ano_desejada  = ano_desejada + 4;
                    }

                    if(ano_desejada == ano_bi && ano_desejada % 100 != 0){
                        anoBi = true;
                    }
                }
                
                if(ano_desejada > ano_bi && valid == false){

                    while(ano_desejada > ano_bi){
                       ano_desejada  = ano_desejada - 4;
                    }

                    if(ano_desejada == ano_bi && ano_desejada % 100 != 0){
                        anoBi = true;
                    }
                }
                return anoBi;
         }

         public static int DiferDatas(String datainicio, String datadesejada) {
               String v_mes_desejada = datadesejada.substring(3,5);
               String v_dia_desejada = datadesejada.substring(0,2);
               String v_ano_desejada = datadesejada.substring(6,10);
               int dt_des_result  = Integer.parseInt(v_ano_desejada + v_mes_desejada + v_dia_desejada);

               String v_mes_inicio = datainicio.substring(3,5);
               String v_dia_inicio = datainicio.substring(0,2);
               String v_ano_inicio = datainicio.substring(6,10);
               int dt_ini_result = Integer.parseInt(v_ano_inicio + v_mes_inicio + v_dia_inicio);

                return (dt_des_result - dt_ini_result);
            }

          public static boolean ValidaData(int[] qtdDiasMes, String dt){
           /*Valida se data é válida*/ 
              boolean valid = true;
              int mes = Integer.parseInt(dt.substring(3,5));
              int dia = Integer.parseInt(dt.substring(0,2));
              int ano = Integer.parseInt(dt.substring(6,10));

                if (mes < 1 || mes > 12){
                    valid = false;
                }
                if(mes == 4 || mes == 6 || mes == 9 || mes == 11 && dia < 1 || dia > 30){
                    valid = false;
                }
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12 && dia < 1 || dia > 31){
                    valid = false;
                }
                if (mes == 2 && dia < 1 || dia > qtdDiasMes[1]){
                    valid = false;
                }
                return valid;
        }

        public static void main(String[] args){
            
            int diaresult = DiaEsperado("03/07/2015", 20, "20/08/2010", 4);
           System.out.println("O dia referente a data informada é: " + diaresult);
       }
}