package net.minecraft.server;


public class RecipesArmor {

    private String a[][] = {
        {
            "XXX", "X X"
        }, {
            "X X", "XXX", "XXX"
        }, {
            "XXX", "X X", "X X"
        }, {
            "X X", "X X"
        }
    };
    private Object b[][];

    public RecipesArmor() {
        b = (new Object[][] {
            new Object[] {
                Item.aD, Block.ar, Item.m, Item.l, Item.n
            }, new Object[] {
                Item.T, Item.X, Item.ab, Item.af, Item.aj
            }, new Object[] {
                Item.U, Item.Y, Item.ac, Item.ag, Item.ak
            }, new Object[] {
                Item.V, Item.Z, Item.ad, Item.ah, Item.al
            }, new Object[] {
                Item.W, Item.aa, Item.ae, Item.ai, Item.am
            }
        });
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < b[0].length; i++) {
            Object obj = b[0][i];

            for (int j = 0; j < b.length - 1; j++) {
                Item item = (Item) b[j + 1][i];

                craftingmanager.a(new ItemStack(item), new Object[] {
                    a[j], Character.valueOf('X'), obj
                });
            }

        }

    }
}

