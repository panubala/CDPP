  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 0
          # Emitting 0
          movl $0, %edi
          # Emitting i0
          subl $4, %esp
        movl %edi, -4(%ebp)
        # Emitting i1 = 1
          # Emitting 1
          movl $1, %esi
          # Emitting i1
          subl $4, %esp
        movl %esi, -8(%ebp)
        # Emitting i2 = 2
          # Emitting 2
          movl $2, %edi
          # Emitting i2
          subl $4, %esp
        movl %edi, -12(%ebp)
        # Emitting i3 = 3
          # Emitting 3
          movl $3, %esi
          # Emitting i3
          subl $4, %esp
        movl %esi, -16(%ebp)
        # Emitting i4 = 4
          # Emitting 4
          movl $4, %edi
          # Emitting i4
          subl $4, %esp
        movl %edi, -20(%ebp)
        # Emitting i5 = 5
          # Emitting 5
          movl $5, %esi
          # Emitting i5
          subl $4, %esp
        movl %esi, -24(%ebp)
        # Emitting i6 = 6
          # Emitting 6
          movl $6, %edi
          # Emitting i6
          subl $4, %esp
        movl %edi, -28(%ebp)
        # Emitting i7 = 7
          # Emitting 7
          movl $7, %esi
          # Emitting i7
          subl $4, %esp
        movl %esi, -32(%ebp)
        # Emitting r1 = (i0 + (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))))
          # Emitting (i0 + (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))))
            # Emitting (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7))))))
              # Emitting (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))
                # Emitting (i3 + (i4 + (i5 + (i6 + i7))))
                  # Emitting (i4 + (i5 + (i6 + i7)))
                    # Emitting (i5 + (i6 + i7))
                      # Emitting (i6 + i7)
                        # Emitting i6
                        movl -28(%ebp), %edi
                        # Emitting i7
                        movl -32(%ebp), %esi
                      addl %esi, %edi
                      # Emitting i5
                      movl -24(%ebp), %esi
                    addl %edi, %esi
                    # Emitting i4
                    movl -20(%ebp), %edi
                  addl %esi, %edi
                  # Emitting i3
                  movl -16(%ebp), %esi
                addl %edi, %esi
                # Emitting i2
                movl -12(%ebp), %edi
              addl %esi, %edi
              # Emitting i1
              movl -8(%ebp), %esi
            addl %edi, %esi
            # Emitting i0
            movl -4(%ebp), %edi
          addl %esi, %edi
          # Emitting r1
          subl $4, %esp
        movl %edi, -36(%ebp)
        # Emitting r2 = (((((((i0 + i1) + i2) + i3) + i4) + i5) + i6) + i7)
          # Emitting (((((((i0 + i1) + i2) + i3) + i4) + i5) + i6) + i7)
            # Emitting ((((((i0 + i1) + i2) + i3) + i4) + i5) + i6)
              # Emitting (((((i0 + i1) + i2) + i3) + i4) + i5)
                # Emitting ((((i0 + i1) + i2) + i3) + i4)
                  # Emitting (((i0 + i1) + i2) + i3)
                    # Emitting ((i0 + i1) + i2)
                      # Emitting (i0 + i1)
                        # Emitting i0
                        movl -4(%ebp), %esi
                        # Emitting i1
                        movl -8(%ebp), %edi
                      addl %edi, %esi
                      # Emitting i2
                      movl -12(%ebp), %edi
                    addl %edi, %esi
                    # Emitting i3
                    movl -16(%ebp), %edi
                  addl %edi, %esi
                  # Emitting i4
                  movl -20(%ebp), %edi
                addl %edi, %esi
                # Emitting i5
                movl -24(%ebp), %edi
              addl %edi, %esi
              # Emitting i6
              movl -28(%ebp), %edi
            addl %edi, %esi
            # Emitting i7
            movl -32(%ebp), %edi
          addl %edi, %esi
          # Emitting r2
          subl $4, %esp
        movl %esi, -40(%ebp)
        # Emitting r3 = (((i0 + i1) + (i2 + i3)) + ((i4 + i5) + (i6 + i7)))
          # Emitting (((i0 + i1) + (i2 + i3)) + ((i4 + i5) + (i6 + i7)))
            # Emitting ((i0 + i1) + (i2 + i3))
              # Emitting (i0 + i1)
                # Emitting i0
                movl -4(%ebp), %edi
                # Emitting i1
                movl -8(%ebp), %esi
              addl %esi, %edi
              # Emitting (i2 + i3)
                # Emitting i2
                movl -12(%ebp), %esi
                # Emitting i3
                movl -16(%ebp), %edx
              addl %edx, %esi
            addl %esi, %edi
            # Emitting ((i4 + i5) + (i6 + i7))
              # Emitting (i4 + i5)
                # Emitting i4
                movl -20(%ebp), %esi
                # Emitting i5
                movl -24(%ebp), %edx
              addl %edx, %esi
              # Emitting (i6 + i7)
                # Emitting i6
                movl -28(%ebp), %edx
                # Emitting i7
                movl -32(%ebp), %ecx
              addl %ecx, %edx
            addl %edx, %esi
          addl %esi, %edi
          # Emitting r3
          subl $4, %esp
        movl %edi, -44(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -36(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(r2)
          # Emitting r2
          movl -40(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(r3)
          # Emitting r3
          movl -44(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
