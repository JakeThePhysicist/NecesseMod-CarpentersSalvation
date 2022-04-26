        package crps;

        import engine.tickManager.TickManager;
        import entity.mobs.PlayerMob;
        import gfx.camera.GameCamera;
        import gfx.drawOptions.texture.TextureDrawOptions;
        import gfx.drawables.LevelSortedDrawable;
        import gfx.drawables.OrderableDrawables;
        import gfx.gameTexture.GameTexture;
        import inventory.item.toolItem.ToolType;
        import java.awt.Color;
        import java.awt.Rectangle;
        import java.util.List;
        import level.gameObject.ObjectHoverHitbox;
        import level.maps.Level;
        import level.gameObject.furniture.LampObject;
        import level.maps.light.GameLight;

    public class crps_streetlight_single_object extends LampObject {

    public crps_streetlight_single_object(String textureName, ToolType toolType, Color mapColor, float lightHue, float lightSat) {
        super(textureName, new Rectangle(4, 4, 24, 24), toolType, mapColor, lightHue, lightSat);
        this.textureName = textureName;
        //gonna keep this commented just in case.
        //this.furnitureType = "candelabra";
    }

    public crps_streetlight_single_object(String textureName, Color mapColor, float lightHue, float lightSat) {
        this(textureName, ToolType.ALL, mapColor, lightHue, lightSat);
    }

            public int getLightLevel(Level level, int x, int y) {
                return this.isActive(level, x, y) ? 160 : 0;
            }


            public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int tileX, int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
                GameLight light = level.getLightLevel(tileX, tileY);
                int drawX = camera.getTileDrawX(tileX);
                int drawY = camera.getTileDrawY(tileY);
                GameTexture texture = this.isActive(level, tileX, tileY) ? this.texture : this.texture_off;
                int rotation = level.getObjectRotation(tileX, tileY) % (texture.getWidth() / 32);
                final TextureDrawOptions options = texture.initDraw().sprite(rotation, 0, 64, texture.getHeight()).light(light).pos(drawX - 16, drawY - texture.getHeight() + 32);
                list.add(new LevelSortedDrawable(this, tileX, tileY) {
                    public int getSortY() {
                        return 16;
                    }

                    public void draw(TickManager tickManager) {
                        options.draw();
                    }
                });
            }

            public void drawPreview(Level level, int tileX, int tileY, int rotations, float alpha, PlayerMob player, GameCamera camera) {
                int drawX = camera.getTileDrawX(tileX);
                int drawY = camera.getTileDrawY(tileY);
                int rotation = (byte)(rotations % (this.texture.getWidth() / 32));
                this.texture.initDraw().sprite(rotation, 0, 64, this.texture.getHeight()).alpha(alpha).draw(drawX - 16, drawY - this.texture.getHeight() + 32);
            }
    public List<ObjectHoverHitbox> getHoverHitboxes(Level level, int tileX, int tileY) {
        List<ObjectHoverHitbox> list = super.getHoverHitboxes(level, tileX, tileY);
        list.add(new ObjectHoverHitbox(tileX, tileY, 0, -28, 32, 44));
        return list;
    }
}
