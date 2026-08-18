package com.qidate.qisplan2;

import com.qidate.qisplan2.event.DeathCurseHudOverlay;
import net.minecraft.client.gui.screens.Screen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = QisPlan2.MODID, dist = Dist.CLIENT)
public class QisPlan2Client {

    public QisPlan2Client(ModContainer modContainer) {
        // 注册配置界面工厂
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, (mc, parent) -> {
            // 直接使用NeoForge提供的通用配置界面
            return new ConfigurationScreen(modContainer, parent);
        });

        // 显式在 mod 事件总线上注册必死诅咒骷髅条的 HUD 图层
        // （不使用已过时的 @EventBusSubscriber(bus = Bus.MOD)）
        modContainer.getEventBus().addListener(DeathCurseHudOverlay::registerDeathCurseLayer);
    }
}