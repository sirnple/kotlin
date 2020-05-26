/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.declarations.builder

import org.jetbrains.kotlin.fir.FirImplementationDetail
import org.jetbrains.kotlin.fir.FirSourceElement
import org.jetbrains.kotlin.fir.builder.FirBuilderDsl
import org.jetbrains.kotlin.fir.declarations.FirDeclaration
import org.jetbrains.kotlin.fir.declarations.FirDeclarationOrigin
import org.jetbrains.kotlin.fir.declarations.FirPluginKey
import org.jetbrains.kotlin.fir.declarations.impl.FirGeneratedClass
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@FirBuilderDsl
class FirGeneratedClassBuilder : FirRegularClassBuilder() {
    lateinit var pluginKey: FirPluginKey

    @Deprecated("Modification of 'source' has no impact for FirGeneratedClassBuilder", level = DeprecationLevel.HIDDEN)
    override var source: FirSourceElement?
        get() = throw IllegalStateException()
        set(value) {
            throw IllegalStateException()
        }

    @Deprecated("Modification of 'origin' has no impact for FirGeneratedClassBuilder", level = DeprecationLevel.HIDDEN)
    override var origin: FirDeclarationOrigin
        get() = throw IllegalStateException()
        set(value) {
            throw IllegalStateException()
        }

    @Deprecated("Modification of 'declarations' has no impact for FirGeneratedClassBuilder", level = DeprecationLevel.HIDDEN)
    override val declarations: MutableList<FirDeclaration>
        get() = throw IllegalStateException()

    @OptIn(FirImplementationDetail::class)
    override fun build(): FirGeneratedClass {
        return FirGeneratedClass(
            session,
            resolvePhase,
            pluginKey,
            annotations,
            typeParameters,
            status,
            classKind,
            scopeProvider,
            name,
            symbol,
            companionObject,
            superTypeRefs,
        )
    }
}

@OptIn(ExperimentalContracts::class)
inline fun buildGeneratedClass(init: FirGeneratedClassBuilder.() -> Unit): FirGeneratedClass {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return FirGeneratedClassBuilder().apply(init).build()
}
