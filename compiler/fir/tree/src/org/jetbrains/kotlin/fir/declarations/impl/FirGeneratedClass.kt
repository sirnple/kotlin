/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.declarations.impl

import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.fir.FirImplementationDetail
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.declarations.*
import org.jetbrains.kotlin.fir.expressions.FirAnnotationCall
import org.jetbrains.kotlin.fir.scopes.FirScopeProvider
import org.jetbrains.kotlin.fir.symbols.impl.FirRegularClassSymbol
import org.jetbrains.kotlin.fir.types.FirTypeRef
import org.jetbrains.kotlin.name.Name

@OptIn(FirImplementationDetail::class)
class FirGeneratedClass @FirImplementationDetail constructor(
    override val session: FirSession,
    override var resolvePhase: FirResolvePhase,
    pluginKey: FirPluginKey,
    annotations: MutableList<FirAnnotationCall>,
    typeParameters: MutableList<FirTypeParameterRef>,
    status: FirDeclarationStatus,
    classKind: ClassKind,
    scopeProvider: FirScopeProvider,
    name: Name,
    symbol: FirRegularClassSymbol,
    companionObject: FirRegularClass?,
    superTypeRefs: MutableList<FirTypeRef>,
) : FirRegularClassImpl(
    source = null,
    session,
    resolvePhase,
    origin = FirDeclarationOrigin.Plugin(pluginKey),
    annotations,
    typeParameters,
    status,
    classKind,
    declarations = mutableListOf(),
    scopeProvider,
    name,
    symbol,
    companionObject,
    superTypeRefs
) {

}