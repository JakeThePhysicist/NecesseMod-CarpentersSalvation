package crps;


import gfx.gameTexture.GameTexture;
import java.awt.Color;
import level.gameObject.WallTorchObject;
import level.maps.Level;

public class crps_lantern_wall_object extends WallTorchObject {
    private final String lantern_texture;

    public crps_lantern_wall_object(String textureName) {
        this.mapColor = new Color(79, 79, 79);
        this.lightLevel = 160;
        this.lantern_texture = "objects/"+ textureName;
    }

    public void loadTextures() {
        super.loadTextures();
        this.texture = GameTexture.fromFile(this.lantern_texture);
    }

    public void tickEffect(Level level, int x, int y) {
    }

    public int getLightLevel(Level level, int x, int y) {
        return this.isActive(level, x, y) ? 160 : 0;
    }

}
