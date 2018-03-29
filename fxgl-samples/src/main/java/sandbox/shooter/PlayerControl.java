/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

package sandbox.shooter;

import com.almasb.fxgl.entity.Component;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.CollidableComponent;
import com.almasb.fxgl.entity.component.PositionComponent;
import com.almasb.fxgl.extra.entity.controls.OffscreenCleanControl;
import com.almasb.fxgl.extra.entity.controls.ProjectileControl;
import com.almasb.fxgl.entity.view.EntityView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public class PlayerControl extends Component {
    @Override
    public void onUpdate(double tpf) {

    }

    public void shoot(Point2D direction) {
        Entity bullet = new Entity();
        bullet.getTypeComponent().setValue(FXShooterApp.EntityType.BULLET);
        bullet.getPositionComponent().setValue(getEntity().getComponent(PositionComponent.class).getValue().add(20, 20));
        bullet.getViewComponent().setView(new EntityView(new Rectangle(10, 2, Color.BLACK)), true);

        bullet.addComponent(new CollidableComponent(true));
        bullet.addComponent(new OffscreenCleanControl());
        bullet.addComponent(new ProjectileControl(direction, 10 * 60));

        BulletComponent bulletData = new BulletComponent();
        bulletData.setDamage(1);
        bulletData.setHp(1);
        bulletData.setSpeed(10);

        bullet.addComponent(bulletData);

        getEntity().getWorld().addEntity(bullet);
    }
}
