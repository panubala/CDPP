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
          # Emitting i0
          subl $4, %esp
          # Emitting 0
          movl $0, %esi
        movl %esi, -4(%ebp)
        # Emitting i1 = 1
          # Emitting i1
          subl $4, %esp
          # Emitting 1
          movl $1, %esi
        movl %esi, -8(%ebp)
        # Emitting i2 = 2
          # Emitting i2
          subl $4, %esp
          # Emitting 2
          movl $2, %esi
        movl %esi, -12(%ebp)
        # Emitting i3 = 3
          # Emitting i3
          subl $4, %esp
          # Emitting 3
          movl $3, %esi
        movl %esi, -16(%ebp)
        # Emitting i4 = 4
          # Emitting i4
          subl $4, %esp
          # Emitting 4
          movl $4, %esi
        movl %esi, -20(%ebp)
        # Emitting i5 = 5
          # Emitting i5
          subl $4, %esp
          # Emitting 5
          movl $5, %esi
        movl %esi, -24(%ebp)
        # Emitting i6 = 6
          # Emitting i6
          subl $4, %esp
          # Emitting 6
          movl $6, %esi
        movl %esi, -28(%ebp)
        # Emitting i7 = 7
          # Emitting i7
          subl $4, %esp
          # Emitting 7
          movl $7, %esi
        movl %esi, -32(%ebp)
        # Emitting r1 = (i0 + (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))))
          # Emitting r1
          subl $4, %esp
          # Emitting (i0 + (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))))
            # Emitting i0
            movl -4(%ebp), %esi
          pushl %esi
            # Emitting (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7))))))
              # Emitting i1
              movl -8(%ebp), %esi
            pushl %esi
              # Emitting (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))
                # Emitting i2
                movl -12(%ebp), %esi
              pushl %esi
                # Emitting (i3 + (i4 + (i5 + (i6 + i7))))
                  # Emitting i3
                  movl -16(%ebp), %esi
                pushl %esi
                  # Emitting (i4 + (i5 + (i6 + i7)))
                    # Emitting i4
                    movl -20(%ebp), %esi
                  pushl %esi
                    # Emitting (i5 + (i6 + i7))
                      # Emitting i5
                      movl -24(%ebp), %esi
                    pushl %esi
                      # Emitting (i6 + i7)
                        # Emitting i6
                        movl -28(%ebp), %esi
                      pushl %esi
                        # Emitting i7
                        movl -32(%ebp), %esi
                      movl -64(%ebp), %edx
                      addl $4, %esp
                      addl %esi, %edx
                    movl -60(%ebp), %esi
                    addl $4, %esp
                    addl %edx, %esi
                  movl -56(%ebp), %edx
                  addl $4, %esp
                  addl %esi, %edx
                movl -52(%ebp), %esi
                addl $4, %esp
                addl %edx, %esi
              movl -48(%ebp), %edx
              addl $4, %esp
              addl %esi, %edx
            movl -44(%ebp), %esi
            addl $4, %esp
            addl %edx, %esi
          movl -40(%ebp), %edx
          addl $4, %esp
          addl %esi, %edx
        movl %edx, -36(%ebp)
        # Emitting r2 = (((((((i0 + i1) + i2) + i3) + i4) + i5) + i6) + i7)
          # Emitting r2
          subl $4, %esp
          # Emitting (((((((i0 + i1) + i2) + i3) + i4) + i5) + i6) + i7)
            # Emitting ((((((i0 + i1) + i2) + i3) + i4) + i5) + i6)
              # Emitting (((((i0 + i1) + i2) + i3) + i4) + i5)
                # Emitting ((((i0 + i1) + i2) + i3) + i4)
                  # Emitting (((i0 + i1) + i2) + i3)
                    # Emitting ((i0 + i1) + i2)
                      # Emitting (i0 + i1)
                        # Emitting i0
                        movl -4(%ebp), %edx
                      pushl %edx
                        # Emitting i1
                        movl -8(%ebp), %edx
                      movl -44(%ebp), %esi
                      addl $4, %esp
                      addl %edx, %esi
                    pushl %esi
                      # Emitting i2
                      movl -12(%ebp), %esi
                    movl -44(%ebp), %edx
                    addl $4, %esp
                    addl %esi, %edx
                  pushl %edx
                    # Emitting i3
                    movl -16(%ebp), %edx
                  movl -44(%ebp), %esi
                  addl $4, %esp
                  addl %edx, %esi
                pushl %esi
                  # Emitting i4
                  movl -20(%ebp), %esi
                movl -44(%ebp), %edx
                addl $4, %esp
                addl %esi, %edx
              pushl %edx
                # Emitting i5
                movl -24(%ebp), %edx
              movl -44(%ebp), %esi
              addl $4, %esp
              addl %edx, %esi
            pushl %esi
              # Emitting i6
              movl -28(%ebp), %esi
            movl -44(%ebp), %edx
            addl $4, %esp
            addl %esi, %edx
          pushl %edx
            # Emitting i7
            movl -32(%ebp), %edx
          movl -44(%ebp), %esi
          addl $4, %esp
          addl %edx, %esi
        movl %esi, -40(%ebp)
        # Emitting r3 = (((i0 + i1) + (i2 + i3)) + ((i4 + i5) + (i6 + i7)))
          # Emitting r3
          subl $4, %esp
          # Emitting (((i0 + i1) + (i2 + i3)) + ((i4 + i5) + (i6 + i7)))
            # Emitting ((i0 + i1) + (i2 + i3))
              # Emitting (i0 + i1)
                # Emitting i0
                movl -4(%ebp), %esi
              pushl %esi
                # Emitting i1
                movl -8(%ebp), %esi
              movl -48(%ebp), %edx
              addl $4, %esp
              addl %esi, %edx
            pushl %edx
              # Emitting (i2 + i3)
                # Emitting i2
                movl -12(%ebp), %edx
              pushl %edx
                # Emitting i3
                movl -16(%ebp), %edx
              movl -52(%ebp), %esi
              addl $4, %esp
              addl %edx, %esi
            movl -48(%ebp), %edx
            addl $4, %esp
            addl %esi, %edx
          pushl %edx
            # Emitting ((i4 + i5) + (i6 + i7))
              # Emitting (i4 + i5)
                # Emitting i4
                movl -20(%ebp), %edx
              pushl %edx
                # Emitting i5
                movl -24(%ebp), %edx
              movl -52(%ebp), %esi
              addl $4, %esp
              addl %edx, %esi
            pushl %esi
              # Emitting (i6 + i7)
                # Emitting i6
                movl -28(%ebp), %esi
              pushl %esi
                # Emitting i7
                movl -32(%ebp), %esi
              movl -56(%ebp), %edx
              addl $4, %esp
              addl %esi, %edx
            movl -52(%ebp), %esi
            addl $4, %esp
            addl %edx, %esi
          movl -48(%ebp), %edx
          addl $4, %esp
          addl %esi, %edx
        movl %edx, -44(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -36(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(r2)
          # Emitting r2
          movl -40(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(r3)
          # Emitting r3
          movl -44(%ebp), %edi
        pushl %edi
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
