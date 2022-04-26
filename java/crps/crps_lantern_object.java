package crps;


import gfx.gameTexture.GameTexture;
import level.gameObject.TorchObject;
import level.maps.Level;
import java.awt.*;


public class crps_lantern_object extends TorchObject {
    private final String lantern_texture;

    public crps_lantern_object(String textureName) {
        this.mapColor = new Color(91, 91, 91);
        this.lightLevel = 160;
        this.lantern_texture = "objects/" + textureName;
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
