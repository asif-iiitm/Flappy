package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

/**
 * Created by uchiha on 16/2/16.
 */
public class MenuState extends State {
    private Texture background;
    private Texture playbtn;
    private BitmapFont font;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        background = new Texture("bg.png");
        playbtn = new Texture("playbtn.png");
        font=new BitmapFont();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));

        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        System.out.println(score);
        //font.draw(sb,"Score : "+ score,100,100);
        //sb.draw(background, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        //sb.draw(playbtn, (MyGdxGame.WIDTH/2)-(playbtn.getWidth()/2),MyGdxGame.HEIGHT/2);
        sb.draw(playbtn,cam.position.x-playbtn.getWidth()/2,cam.position.y);
        //font.draw(sb,"Lol Loser  !! ", 100, 250);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
        System.out.println("Menu State Disposed");
    }
}
