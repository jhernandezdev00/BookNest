package com.proyectos.GestorDeLibros_BookNest.Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mapeoResultados {
    public void mapeoResultadosBooks(List<Object[]> resultados){
        if(resultados.isEmpty()){
            System.out.println("NO HAY LIBROS REGISTRADOS");
        }else{
            for (Object[] fila:resultados){
                System.out.println("=================================");
                System.out.println("Titulo del Libro        => " + ((String) fila[0] != null ? (String) fila[0] : "Desconocido"));
                System.out.println("Autor del Libro         => " + ((String) fila[1] != null ? (String) fila[1] : "Desconocido"));
                System.out.println("Idiomas Disponibles     => " + (Arrays.toString((Object[]) fila[2])));
                System.out.println("Genero del Libro        => " + (Arrays.toString((Object[]) fila[3])));
                System.out.println("Num. de Descargas       => " + (fila[4]));
                if(fila[5].equals(false)){
                    System.out.println("Vig. Derechos de Autor  => SIN DERECHOS DE AUTOR");
                }else{
                    System.out.println("Vig. Derechos de Autor  => CON DERECHOS DE AUTOR");
                }
            }
        }
    }

    public void mapeoResultadosAuthors(List<ClaseAutores> resultadosAutores){
        if(resultadosAutores.isEmpty()){
            System.out.println("NO SE HAN ENCONTRADO ESCRITORES");
        }else{
            for(int i=0; i<resultadosAutores.size(); i++){
                System.out.println("=================================");
                System.out.println("Nombre del Escritor     => "+resultadosAutores.get(i).getNombreAutor());
                System.out.println("Año de Nacimiento       => "+resultadosAutores.get(i).getYearNacimiento());
                System.out.println("Año de Fallecimiento    => "+resultadosAutores.get(i).getYearFallecimiento());
            }
        }
    }

    public static class idiomasLibros {
        public Map<String, String> listarIdiomas(){
            Map<String, String> idiomas = new HashMap<>();
            idiomas.put("aa", "Afar");
            idiomas.put("ab", "Abjasio");
            idiomas.put("ae", "Avestan");
            idiomas.put("af", "Afrikaans");
            idiomas.put("ak", "Akan");
            idiomas.put("am", "Amárico");
            idiomas.put("an", "Aragonés");
            idiomas.put("ar", "Árabe");
            idiomas.put("as", "Assamés");
            idiomas.put("av", "Avaric");
            idiomas.put("ay", "Aymara");
            idiomas.put("az", "Azerbaiyano");
            idiomas.put("ba", "Bashkir");
            idiomas.put("be", "Bielorruso");
            idiomas.put("bg", "Búlgaro");
            idiomas.put("bh", "Bihari");
            idiomas.put("bi", "Bislama");
            idiomas.put("bn", "Bengalí");
            idiomas.put("bo", "Tibetano");
            idiomas.put("br", "Bretón");
            idiomas.put("bs", "Bosnio");
            idiomas.put("ca", "Catalán");
            idiomas.put("ce", "Checheno");
            idiomas.put("ch", "Chamorro");
            idiomas.put("co", "Corso");
            idiomas.put("cr", "Cree");
            idiomas.put("cs", "Checo");
            idiomas.put("cu", "Eclesiástico eslavo");
            idiomas.put("cv", "Chuvash");
            idiomas.put("cy", "Galés");
            idiomas.put("da", "Danés");
            idiomas.put("de", "Alemán");
            idiomas.put("dv", "Dhivehi");
            idiomas.put("dz", "Dzongkha");
            idiomas.put("ee", "Ewe");
            idiomas.put("el", "Griego");
            idiomas.put("en", "Inglés");
            idiomas.put("eo", "Esperanto");
            idiomas.put("es", "Español");
            idiomas.put("et", "Estonio");
            idiomas.put("eu", "Euskera");
            idiomas.put("fa", "Persa");
            idiomas.put("ff", "Fulah");
            idiomas.put("fi", "Finlandés");
            idiomas.put("fj", "Fiyiano");
            idiomas.put("fo", "Feroés");
            idiomas.put("fr", "Francés");
            idiomas.put("ga", "Irlandés");
            idiomas.put("gd", "Gaélico escocés");
            idiomas.put("gl", "Gallego");
            idiomas.put("gn", "Guaraní");
            idiomas.put("gu", "Gujarati");
            idiomas.put("gv", "Manés");
            idiomas.put("ha", "Hausa");
            idiomas.put("he", "Hebreo");
            idiomas.put("hi", "Hindi");
            idiomas.put("ho", "Hiri Motu");
            idiomas.put("hr", "Croata");
            idiomas.put("ht", "Haitiano");
            idiomas.put("hu", "Húngaro");
            idiomas.put("hy", "Armenio");
            idiomas.put("hz", "Herero");
            idiomas.put("ia", "Interlingua");
            idiomas.put("id", "Indonesio");
            idiomas.put("ie", "Interlingue");
            idiomas.put("ig", "Igbo");
            idiomas.put("ii", "Yi");
            idiomas.put("ik", "Inupiaq");
            idiomas.put("io", "Ido");
            idiomas.put("is", "Islandés");
            idiomas.put("it", "Italiano");
            idiomas.put("iu", "Inuktitut");
            idiomas.put("ja", "Japonés");
            idiomas.put("jv", "Javanés");
            idiomas.put("ka", "Georgiano");
            idiomas.put("kk", "Kazajo");
            idiomas.put("kl", "Kalaallisut");
            idiomas.put("km", "Jemer");
            idiomas.put("kn", "Canarés");
            idiomas.put("ko", "Coreano");
            idiomas.put("kr", "Kanuri");
            idiomas.put("ks", "Cachemir");
            idiomas.put("ku", "Kurdo");
            idiomas.put("kv", "Komi");
            idiomas.put("kw", "Córnico");
            idiomas.put("ky", "Kirguís");
            idiomas.put("la", "Latín");
            idiomas.put("lb", "Luxemburgués");
            idiomas.put("lo", "Laosiano");
            idiomas.put("lt", "Lituano");
            idiomas.put("lu", "Luba-Katanga");
            idiomas.put("lv", "Letón");
            idiomas.put("mg", "Malgache");
            idiomas.put("mh", "Islas Marshall");
            idiomas.put("mi", "Maorí");
            idiomas.put("mk", "Macedonio");
            idiomas.put("ml", "Malayalam");
            idiomas.put("mn", "Mongol");
            idiomas.put("mr", "Maratí");
            idiomas.put("ms", "Malaio");
            idiomas.put("mt", "Maltés");
            idiomas.put("my", "Birmano");
            idiomas.put("na", "Nauruano");
            idiomas.put("nb", "Noruego bokmål");
            idiomas.put("nd", "Ndebele del norte");
            idiomas.put("ne", "Nepalí");
            idiomas.put("nl", "Neerlandés");
            idiomas.put("nn", "Noruego nynorsk");
            idiomas.put("no", "Noruego");
            idiomas.put("nr", "Ndebele del sur");
            idiomas.put("nv", "Navajo");
            idiomas.put("ny", "Nianja");
            idiomas.put("oc", "Occitano");
            idiomas.put("oj", "Ojibwa");
            idiomas.put("om", "Oromo");
            idiomas.put("or", "Odia");
            idiomas.put("os", "Osetio");
            idiomas.put("pa", "Punjabi");
            idiomas.put("pi", "Pali");
            idiomas.put("pl", "Polaco");
            idiomas.put("ps", "Pashto");
            idiomas.put("pt", "Portugués");
            idiomas.put("qu", "Quechua");
            idiomas.put("rm", "Retorromano");
            idiomas.put("rn", "Kirundi");
            idiomas.put("ro", "Rumano");
            idiomas.put("ru", "Ruso");
            idiomas.put("rw", "Kinyarwanda");
            idiomas.put("se", "Sami del norte");
            idiomas.put("sg", "Sango");
            idiomas.put("si", "Cingalés");
            idiomas.put("sk", "Eslovaco");
            idiomas.put("sl", "Esloveno");
            idiomas.put("sm", "Samoano");
            idiomas.put("sn", "Shona");
            idiomas.put("so", "Somalí");
            idiomas.put("sq", "Albanés");
            idiomas.put("sr", "Serbio");
            idiomas.put("ss", "Swati");
            idiomas.put("st", "Sesotho");
            idiomas.put("su", "Sundanés");
            idiomas.put("sv", "Sueco");
            idiomas.put("sw", "Suajili");
            idiomas.put("ta", "Tamil");
            idiomas.put("te", "Telugu");
            idiomas.put("tg", "Tártaro");
            idiomas.put("th", "Tailandés");
            idiomas.put("tl", "Tagalo");
            idiomas.put("tn", "Tswana");
            idiomas.put("to", "Tongano");
            idiomas.put("tr", "Turco");
            idiomas.put("ts", "Tsonga");
            idiomas.put("tt", "Tártaro");
            idiomas.put("tw", "Twi");
            idiomas.put("uk", "Ucraniano");
            idiomas.put("ur", "Urdu");
            idiomas.put("vi", "Vietnamita");
            idiomas.put("vo", "Volapük");
            idiomas.put("wa", "Valón");
            idiomas.put("wo", "Wolof");
            idiomas.put("xh", "Xhosa");
            idiomas.put("yi", "Yidis");
            idiomas.put("zu", "Zulú");

            return idiomas;
        }
    }
}
