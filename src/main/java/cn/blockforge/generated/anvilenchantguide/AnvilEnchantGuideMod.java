package cn.blockforge.generated.anvilenchantguide;

import net.neoforged.fml.common.Mod;

/**
 * JEI recipe refactoring。
 *
 * <p>本模组自身不注册任何物品或方块，所有内容由 JEI / EMI 插件提供：
 * 根据当前服务器同步的附魔数据提供物品、附魔书和修复材料三个查询视图。
 * 客户端集成由对应浏览器发现，公共入口不加载客户端或可选模组的类。</p>
 */
@Mod(AnvilEnchantGuideMod.MOD_ID)
public final class AnvilEnchantGuideMod {

    public static final String MOD_ID = "anvil_enchant_guide";

    public AnvilEnchantGuideMod() {
        // 浏览器分别扫描 @JeiPlugin / @EmiEntrypoint，公共入口无需引用其 API。
    }
}
