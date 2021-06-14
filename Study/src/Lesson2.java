public class Lesson2 {
    public static void main(String[] args) {
        String[] roles = new String[]{
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич",
                "Демис Карибидис",
                "Лука"
        };
        String[] textLines = new String[]{
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                "Лука Лукич: сэмпл текс Лука Лукич:",
                "Лука Лукич: Лука: Господи боже!  еще и с секретным предписаньем",
                "  "
        };
        System.out.println(printTextPerRole(roles, textLines));
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder scenar = new StringBuilder();
        String scenarFin;
        for (int m = 0; m < roles.length; m++) {
            String[] title = roles[m].split(" ");
            scenar.append(roles[m]).append(":").append('\n');
            for (int g = 0; g < textLines.length; g++) {
                String string = textLines[g];
                if (string.startsWith(roles[m] + ":")) {
                    String string1 = string.replaceFirst(roles[m] + ":", String.valueOf(g + 1) + ")");
                    scenar.append(string1).append('\n');
                }
            }
            scenar.append('\n');
        }
        scenarFin = scenar.toString();
        return scenarFin;
    }

}
