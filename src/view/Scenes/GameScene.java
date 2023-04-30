package view.Scenes;

import view.Scenes.Game.Game;

public class GameScene {
    private Game game;
    public GameScene(Game game){
        this.game = game;
    }
    public Game getGame(Game game){
        return game;
    }
}
