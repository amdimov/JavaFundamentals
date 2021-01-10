import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    static class Heroes{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHP() {
            return HP;
        }

        public void setHP(int HP) {
            this.HP = HP;
        }

        public int getMP() {
            return MP;
        }

        public void setMP(int MP) {
            this.MP = MP;
        }

        int HP;
        int MP;

        public Heroes(String name, int HP, int MP){
            this.name = name;
            if (HP < 100) {
                this.HP = HP;
            }else {
                this.HP = 100;
            }
            if (MP < 200) {
                this.MP = MP;
            }else {
                this.MP = 200;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Heroes> heroesMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputSplit = input.split("\\s+");
            String heroName = inputSplit[0];
            int heroHP = Integer.parseInt(inputSplit[1]);
            int heroMP = Integer.parseInt(inputSplit[2]);
            Heroes hero = heroesMap.get(heroName);

            if (hero == null){
                hero = new Heroes(heroName, heroHP, heroMP);
                heroesMap.put(heroName, hero);
            }
        }

        String input = scanner.nextLine().trim();


        while (!input.equals("End")){
            String[] inputSplit = input.split("\\s*[-]\\s* ");
            String action = inputSplit[0];
            String heroName = inputSplit[1];
            Heroes hero = heroesMap.get(heroName);

            switch (action){
                case "CastSpell":
                    int MPneeded = Integer.parseInt(inputSplit[2]);
                    String spellName = inputSplit[3];

                    if (hero != null){
                        if (hero.getMP() >= MPneeded){
                            hero.setMP(hero.getMP() - MPneeded);
                            System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                    hero.getName(), spellName, hero.getMP());
                        }else {
                            System.out.printf("%s does not have enough MP to cast %s!%n", hero.getName(), spellName);
                        }
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(inputSplit[2]);
                    String attacker = inputSplit[3];
                    if (hero != null){
                        if (hero.getHP() > damage){
                            hero.setHP(hero.getHP() - damage);
                            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                    hero.getName(), damage, attacker, hero.getHP());
                        }else {
                            System.out.printf("%s has been killed by %s!%n", hero.getName(), attacker);
                            heroesMap.remove(heroName);
                        }
                    }
                    break;
                case "Recharge":
                    int rechargeMP = Integer.parseInt(inputSplit[2]);
                    int currentMP = hero.getMP();
                    if (hero != null) {
                        if (hero.getMP() + rechargeMP > 200) {
                            hero.setMP(200);
                            System.out.printf("%s recharged for %d MP!%n", heroName, 200 - currentMP);
                        }else {
                            hero.setMP(hero.getMP() + rechargeMP);
                            System.out.printf("%s recharged for %d MP!%n", heroName, rechargeMP);
                        }
                    }
                    break;
                case "Heal":
                    int healAmount = Integer.parseInt(inputSplit[2]);
                    int currentHP = hero.getHP();
                    if (hero != null) {
                        if (hero.getHP() + healAmount > 100) {
                            hero.setHP(100);
                            System.out.printf("%s healed for %d HP!%n", heroName, 100 - currentHP);
                        }else {
                            hero.setHP(hero.getHP() + healAmount);
                            System.out.printf("%s healed for %d HP!%n", heroName, healAmount);
                        }
                    }
                    break;

            }
            input = scanner.nextLine().trim();
        }

        heroesMap.entrySet().stream().sorted((a,b)->{
            if (a.getValue().getHP() != b.getValue().getHP()){
                return Integer.compare(b.getValue().getHP(), a.getValue().getHP());
            }else {
                return a.getValue().getName().compareTo(b.getValue().getName());
            }
        })
        .forEach(e ->
        {
            System.out.println(e.getValue().getName());
            System.out.println("  HP: " + e.getValue().getHP());
            System.out.println("  MP: " + e.getValue().getMP());
        });

//        heroesMap.entrySet().stream().forEach(e -> System.out.println(e.getValue().getName()
//                + " " + e.getValue().getHP()+ " " + e.getValue().getMP()));
    }
}
