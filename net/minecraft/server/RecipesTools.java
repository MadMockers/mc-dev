package net.minecraft.server;


public class RecipesTools {

    private String a[][] = {
        {
            "XXX", " # ", " # "
        }, {
            "X", "#", "#"
        }, {
            "XX", "X#", " #"
        }, {
            "XX", " #", " #"
        }
    };
    private Object b[][];

    public RecipesTools() {
        b = (new Object[][] {
            new Object[] {
                Block.x, Block.w, Item.m, Item.l, Item.n
            }, new Object[] {
                Item.r, Item.v, Item.e, Item.z, Item.G
            }, new Object[] {
                Item.q, Item.u, Item.d, Item.y, Item.F
            }, new Object[] {
                Item.s, Item.w, Item.f, Item.A, Item.H
            }, new Object[] {
                Item.L, Item.M, Item.N, Item.O, Item.P
            }
        });
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < b[0].length; i++) {
            Object obj = b[0][i];

            for (int j = 0; j < b.length - 1; j++) {
                Item item = (Item) b[j + 1][i];

                craftingmanager.a(new ItemStack(item), new Object[] {
                    a[j], Character.valueOf('#'), Item.B, Character.valueOf('X'), obj
                });
            }

        }

    }
}

