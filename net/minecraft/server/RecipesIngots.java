package net.minecraft.server;


public class RecipesIngots {

    private Object a[][];

    public RecipesIngots() {
        a = (new Object[][] {
            new Object[] {
                Block.ah, Item.n
            }, new Object[] {
                Block.ai, Item.m
            }, new Object[] {
                Block.ax, Item.l
            }
        });
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < a.length; i++) {
            Block block = (Block) a[i][0];
            Item item = (Item) a[i][1];

            craftingmanager.a(new ItemStack(block), new Object[] {
                "###", "###", "###", Character.valueOf('#'), item
            });
            craftingmanager.a(new ItemStack(item, 9), new Object[] {
                "#", Character.valueOf('#'), block
            });
        }

    }
}

